using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.InputSystem;

public class InputManager
{
    public event Action OnShoot;
    public Vector2 Moviment => Controls.GamePlay.Moviment.ReadValue<Vector2>();
    private Controls Controls;

    public InputManager()
    {
        Controls = new Controls();
        Controls.GamePlay.Enable();
        Controls.GamePlay.Shoot.performed += ShootPerformed;
    }

    private void ShootPerformed(InputAction.CallbackContext context)
    {
        OnShoot?.Invoke();
    }
}
