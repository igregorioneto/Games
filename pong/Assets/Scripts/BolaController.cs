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
        int direcao = Random.Range(0,4);
        if (direcao == 0)
        {
            minhaVelocidade.x = velocidade; 
            minhaVelocidade.y = velocidade;
        } else if (direcao == 1)
        {
            minhaVelocidade.x = -velocidade; 
            minhaVelocidade.y = velocidade;
        } else if (direcao == 2)
        {
            minhaVelocidade.x = -velocidade; 
            minhaVelocidade.y = -velocidade;
        } else if (direcao == 3)
        {
            minhaVelocidade.x = velocidade; 
            minhaVelocidade.y = -velocidade;
        }
        meuRB.velocity = minhaVelocidade;
    }

    // Update is called once per frame
    void Update()
    {
        
    }
}
