using System.Collections;
using UnityEngine;
using UnityEngine.AI;
using UnityEngine.SceneManagement;

// some lines are commented because it is code for future update (maybe?)
// like attacking and animations. i kept them just in case :P 

public enum EnemyState
{
    Patrolling,
    Chasing,
    //Attacking
}

public class EnemyAI : MonoBehaviour
{
    [Header("Monster Audio")]
    [SerializeField] private AudioSource monsterSource;
    [SerializeField] private AudioClip growlClip; // loop while patrolling
    [SerializeField] private AudioClip roarClip;  // loop while chasing

    [Header("Game Over")]
    [SerializeField] private CanvasGroup caughtTextGroup;
    [SerializeField] private float caughtRestartDelay = 1.5f;
    [SerializeField] private CanvasGroup grayOverlay;
    [SerializeField] private FPSController playerController;

    [Header("References")]
    [SerializeField] private Transform[] patrolPoints;
    [SerializeField] private Transform player;

    [Header("Settings")]
    [SerializeField] private float patrolWaitTime = 2f;
    [SerializeField] private float stopAtDistance = .5f;
    [SerializeField] private float detectionRange = 20f;
    [SerializeField] private float viewAngle = 90f;
    [SerializeField] private float losePlayerTime = 3f;
    [SerializeField] private float killRange = 1.2f;

    private EnemyState lastAudioState;
    private NavMeshAgent agent;
    private int currentPatrolIndex;
    private bool isWaiting;
    private EnemyState state = EnemyState.Patrolling;
    private float timeSinceLastSeenPlayer;
    //private bool isAttacking;
    private bool playerCaught;
    //private Animator animator;


    private void Awake()
    {
        agent = GetComponent<NavMeshAgent>();
        //animator = GetComponent<Animator>();
    }

    private void Start()
    {
        UpdateMonsterAudio();
        GoToNextPatrolPoint();
        playerController = FindFirstObjectByType<FPSController>();
    }

    private void Update()
    {
        var distanceToPlayer = Vector3.Distance(player.position, transform.position);

        switch (state){
            case EnemyState.Patrolling:
                Patrol();
                if(distanceToPlayer <= detectionRange && CanSeePlayer())
                {
                    state = EnemyState.Chasing;
                }
                break;

            case EnemyState.Chasing:
                if (!playerCaught && distanceToPlayer <= killRange)
                {
                    playerCaught = true;
                    AudioManagerHub.Instance?.PlayLose();
                    StartCoroutine(PlayerCaught());
                    return;
                }

                Follow();

                //if(distanceToPlayer <= attackRange)
                //{
                //    state = EnemyState.Attacking;
                //    StartAttack();
                //}

                if (!CanSeePlayer())
                {
                    timeSinceLastSeenPlayer += Time.deltaTime;
                    if (timeSinceLastSeenPlayer >= losePlayerTime)
                    {
                        state = EnemyState.Patrolling;
                        GoToClosestPatrolPoint();
                    }
                }
                else
                {
                    timeSinceLastSeenPlayer = 0f;
                }
                break;

            //case EnemyState.Attacking:
            //    Attack();
            //    if(!isAttacking && distanceToPlayer > attackRange)
            //    {
            //        state = EnemyState.Chasing;
            //        agent.isStopped = false;
            //    }
            //    break;
        }

        Patrol();
        //UpdateAnimations();
    }

    private void UpdateMonsterAudio()
    {
        if (monsterSource == null) return;

        // Only react when state changes (prevents restarting sound every frame)
        if (state == lastAudioState) return;
        lastAudioState = state;

        switch (state)
        {
            case EnemyState.Patrolling:
                PlayLoop(monsterSource, growlClip);
                break;

            case EnemyState.Chasing:
                PlayLoop(monsterSource, roarClip);
                break;

            default:
                monsterSource.Stop();
                break;
        }
    }

    private void PlayLoop(AudioSource src, AudioClip clip)
    {
        if (clip == null)
        {
            src.Stop();
            return;
        }

        src.loop = true;

        if (src.clip != clip)
            src.clip = clip;

        if (!src.isPlaying)
            src.Play();
    }


    private void Patrol()
    {
        if(isWaiting) return;
        if(!agent.pathPending && agent.remainingDistance <= stopAtDistance)
        {
            StartCoroutine(WaitAtPatrolPoint());
        }
    }

    private void Follow()
    {
        agent.SetDestination(player.position);
    }

    // scrapped, but kept for future implementation (?)
    //private void Attack()
    //{
    //    agent.isStopped = true;
    //    var direction = (player.position - transform.position).normalized;
    //    direction.y = 0f;
    //    if(direction != Vector3.zero)
    //    {
    //        transform.rotation = Quaternion.LookRotation(direction);
    //    }
    //}

    //private void StartAttack()
    //{
    //    agent.isStopped = true;
    //    isAttacking = true;
    //    //animator.SetTrigger("Attack");
    //}

    private IEnumerator WaitAtPatrolPoint()
    {
        isWaiting = true;
        agent.isStopped = true;

        yield return new WaitForSeconds(patrolWaitTime);

        agent.isStopped = false;
        GoToNextPatrolPoint();
        isWaiting = false;
    }

    private void GoToClosestPatrolPoint()
    {
        if (patrolPoints.Length == 0) return;

        var closestIndex = 0;
        var closestDistance = float.MaxValue;

        for(var i = 0; i < patrolPoints.Length; i++)
        {
            var distance = Vector3.Distance(transform.position, patrolPoints[i].position);
            if(distance < closestDistance)
            {
                closestDistance = distance;
                closestIndex = i;
            }
        }

        currentPatrolIndex = closestIndex;
        agent.SetDestination(patrolPoints[currentPatrolIndex].position);
    }

    private void GoToNextPatrolPoint()
    {
        if(patrolPoints.Length == 0)
            return;

        agent.SetDestination(patrolPoints[currentPatrolIndex].position);
        currentPatrolIndex = (currentPatrolIndex + 1) % patrolPoints.Length;
    }

    private bool CanSeePlayer()
    {
        return IsFacingPlayer() && HasClearPathToPlayer();
    }

    private bool IsFacingPlayer()
    {
        Vector3 directionToPlayer = (player.position - transform.position).normalized;
        var angleToPlayer = Vector3.Angle(transform.forward, directionToPlayer);
        return angleToPlayer < viewAngle / 2f;
    }

    private bool HasClearPathToPlayer()
    {
        Vector3 directionToPlayer = (player.position - transform.position).normalized;
        if(Physics.Raycast(transform.position, directionToPlayer.normalized, out RaycastHit hit, directionToPlayer.magnitude))
        {
            return hit.transform == player;
        }

        return true;
    }

    private IEnumerator PlayerCaught()
    {
        agent.isStopped = true;

        if (playerController != null)
            playerController.enabled = false;

        if (grayOverlay != null)
            grayOverlay.alpha = 1f;

        if (caughtTextGroup != null)
            caughtTextGroup.alpha = 1f;
        
        yield return new WaitForSecondsRealtime(caughtRestartDelay);

        SceneManager.LoadScene(SceneManager.GetActiveScene().buildIndex);
    }

    // commented because there are no animations in the model i downloaded
    // i left it here so that i know where to add them later on :P
    //private void UpdateAnimations() { }

}
