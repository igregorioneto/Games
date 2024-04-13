using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BolaController : MonoBehaviour
{
    public Rigidbody2D meuRB;
    public float velocidade = 5f;
    private Vector2 minhaVelocidade;
    
    // Start is called before the first frame update
    void Start()
    {
        minhaVelocidade.x = -velocidade;
        meuRB.velocity = minhaVelocidade;
    }

    // Update is called once per frame
    void Update()
    {
        
    }
}
