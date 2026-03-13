using System.Collections;
using Unity.VisualScripting;
using UnityEngine;
using UnityEngine.AI;
using UnityEngine.Events;
using UnityEngine.SceneManagement;

public class PlayerInventory : MonoBehaviour
{
    public int NumberOfVHS { get; private set; }

    [Header("Win Settings")]
    [SerializeField] private int vhsToWin = 7;
    [SerializeField] private float winRestartDelay = 5f;
    [SerializeField] private CanvasGroup winTextGroup;
    [SerializeField] private CanvasGroup grayOverlay;

    public UnityEvent<PlayerInventory> OnVHSCollected = new UnityEvent<PlayerInventory>();

    private FPSController fpsController;
    private bool hasWon;

    private void Awake()
    {
        fpsController = GetComponent<FPSController>();
    }

    public void VHSCollected()
    {
        if (hasWon) return;

        NumberOfVHS++;
        OnVHSCollected.Invoke(this);

        if (NumberOfVHS >= vhsToWin)
        {
            hasWon = true;
            AudioManagerHub.Instance?.PlayWin();
            DisableEnemyAI();
            StartCoroutine(HandleWinCondition());
        }
    }

    private void DisableEnemyAI()
    {
        EnemyAI[] enemies = FindObjectsByType<EnemyAI>(FindObjectsSortMode.None);

        foreach (EnemyAI enemy in enemies)
        {
            NavMeshAgent agent = enemy.GetComponent<NavMeshAgent>();
            if (agent != null)
            {
                agent.isStopped = true;
                agent.ResetPath();
                agent.velocity = Vector3.zero;

                agent.enabled = false;
            }
            enemy.enabled = false;
        }
    }

    private IEnumerator HandleWinCondition()
    {
        if(fpsController != null)
            fpsController.enabled = false;

        if(grayOverlay != null)
            grayOverlay.alpha = 1f;

        if(winTextGroup != null)
            winTextGroup.alpha = 1f;

        yield return new WaitForSeconds(winRestartDelay);

        SceneManager.LoadScene(SceneManager.GetActiveScene().buildIndex);
    }
}
