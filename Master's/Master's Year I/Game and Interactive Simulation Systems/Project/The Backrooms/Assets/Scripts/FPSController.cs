using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class FPSController : MonoBehaviour
{
    [Header("Movement Speeds")]
    [SerializeField] private float walkSpeed = 5f;
    [SerializeField] private float sprintMultiplier = 2f;

    [Header("Look Sensitivity")]
    [SerializeField] private float lookSensitivity = 2f;
    [SerializeField] private float maxLookAngle = 80f;

    private float stepTimer;
    private CharacterController characterController;
    private Camera mainCamera;
    private PlayerInputHandler inputHandler;
    private Vector3 currentMovement;
    private float verticalRotation;
    private bool wasMoving;

    private void Awake()
    {
        characterController = GetComponent<CharacterController>();

        if (mainCamera == null)
            mainCamera = GetComponentInChildren<Camera>(true);

        inputHandler = PlayerInputHandler.Instance;
    }

    private void Update()
    {
        HandleMovement();
        HandleRotation();
    }

    void HandleMovement()
    {
        float speed = walkSpeed * (inputHandler.SprintValue > 0 ? sprintMultiplier : 1f);

        Vector3 inputDirection = new Vector3(inputHandler.MoveInput.x, 0f, inputHandler.MoveInput.y);
        Vector3 worldDirection = transform.TransformDirection(inputDirection);
        worldDirection.Normalize();

        currentMovement.x = worldDirection.x * speed;
        currentMovement.z = worldDirection.z * speed;

        characterController.Move(currentMovement * Time.deltaTime);
    }

    void HandleRotation()
    {
        float mouseXRotation = inputHandler.LookInput.x * lookSensitivity;
        transform.Rotate(0f, mouseXRotation, 0f);

        verticalRotation -= inputHandler.LookInput.y * lookSensitivity;
        verticalRotation = Mathf.Clamp(verticalRotation, -maxLookAngle, maxLookAngle);

        mainCamera.transform.localRotation = Quaternion.Euler(verticalRotation, 0f, 0f);
    }
}
