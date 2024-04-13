using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class RaqueteController : MonoBehaviour
{
    private Vector3 minhaPosicao;
    private float meuY;
    public float velocidade;
    public float meuLimite;
    public bool isPlayer1;
    // Start is called before the first frame update
    void Start()
    {
        minhaPosicao = transform.position;
    }

    // Update is called once per frame
    void Update()
    {
        minhaPosicao.y = meuY;
        transform.position = minhaPosicao;
        float deltaVelocidade = velocidade * Time.deltaTime;


        if (Input.GetKey(KeyCode.UpArrow) && isPlayer1)
        {
            // Debug.Log("UP");
            meuY += deltaVelocidade;
        }
        if (Input.GetKey(KeyCode.DownArrow) && isPlayer1)
        {
            // Debug.Log("DOWN");
            meuY -= deltaVelocidade;
        }
        if (Input.GetKey(KeyCode.W) && !isPlayer1)
        {
            meuY += deltaVelocidade;
        }
        if (Input.GetKey(KeyCode.S) && !isPlayer1)
        {
            meuY -= deltaVelocidade;
        }

        if (meuY < -meuLimite)
        {
            meuY = -meuLimite;
        }

        if (meuY > meuLimite) 
        {
            meuY = meuLimite;
        }
    }
}
