using System.Collections;
using System.Collections.Generic;
using Unity.VisualScripting;
using UnityEngine;

public class RaqueteController : MonoBehaviour
{
    private Vector3 minhaPosicao;
    private float meuY;
    public Transform transformBola;
    public float velocidade;
    public float meuLimite;
    public bool isPlayer1;
    public bool automatico = false;
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

        // Modo Computador
        if (!automatico)
        {
            if (isPlayer1)
            {
                // Player 1
                if (Input.GetKey(KeyCode.W) && isPlayer1)
                {
                    // Debug.Log("UP");
                    meuY += deltaVelocidade;
                }
                if (Input.GetKey(KeyCode.S) && isPlayer1)
                {
                    // Debug.Log("DOWN");
                    meuY -= deltaVelocidade;
                } 
            } 
            else 
            {
                if (Input.GetKey(KeyCode.Return))
                {
                    automatico = true;
                }
                //  Modo Player 2
                if (Input.GetKey(KeyCode.UpArrow) && !isPlayer1 && !automatico)
                {
                    meuY += deltaVelocidade;
                }
                if (Input.GetKey(KeyCode.DownArrow) && !isPlayer1 && !automatico)
                {
                    meuY -= deltaVelocidade;
                }
            }
        } else {       
            if (Input.GetKey(KeyCode.UpArrow) || Input.GetKey(KeyCode.DownArrow))
            {
                automatico = false;
            }
            meuY = Mathf.Lerp(meuY, transformBola.position.y, 0.02f);
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
