using UnityEngine;

public class CameraRotation : MonoBehaviour
{
    public Vector2 turn;
    //public float sensitivity = .5f;

    void Start()
    {
        Cursor.lockState = CursorLockMode.Locked;
    }

    // Update is called once per frame
    void Update()
    {
        turn.x += Input.GetAxis("Mouse X"); //* sensitivity;
        turn.y += Input.GetAxis("Mouse Y"); //* sensitivity;
        transform.localRotation = Quaternion.Euler(-turn.y, turn.x, 0);
    }
}
