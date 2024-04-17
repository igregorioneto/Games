using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ObstaculoController : MonoBehaviour
{
    [SerializeField] private float velocidade = 5f;
    void Start()
    {
        
    }

    void Update()
    {
        transform.position += Vector3.left * Time.deltaTime * velocidade;
    }
}
