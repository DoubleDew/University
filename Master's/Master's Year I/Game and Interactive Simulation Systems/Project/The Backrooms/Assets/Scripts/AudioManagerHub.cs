using UnityEngine;

public class AudioManagerHub : MonoBehaviour
{
    public static AudioManagerHub Instance { get; private set; }

    [Header("Sources")]
    [SerializeField] private AudioSource musicSource;
    [SerializeField] private AudioSource stingerSource;

    [Header("Clips")]
    [SerializeField] private AudioClip winClip;
    [SerializeField] private AudioClip loseClip;

    private void Awake()
    {
        if(Instance != null)
        {
            Destroy(gameObject);
            return;
        }

        Instance = this;
        DontDestroyOnLoad(gameObject);
    }

    public void PlayWin()
    {
        if (musicSource != null && musicSource.isPlaying)
            musicSource.volume = 0f;

        if (stingerSource != null && winClip != null)   
            stingerSource.PlayOneShot(winClip);
    }

    public void PlayLose()
    {
        if (musicSource != null && musicSource.isPlaying)
            musicSource.volume = 0f;

        if (stingerSource != null && loseClip != null)
            stingerSource.PlayOneShot(loseClip);
    }

    public void StopMusic()
    {
        if (musicSource != null)
            musicSource.Stop();
    }
}
