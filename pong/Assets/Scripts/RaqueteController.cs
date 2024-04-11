using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class RaqueteController : MonoBehaviour
{
    private Vector3 minhaPosicao;
    public float meuY;
    public float velocidade;
    public float meuLimite;
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

        if (Input.GetKey(KeyCode.UpArrow) && meuY < meuLimite) 
        {
            // Debug.Log("UP");
            meuY += velocidade * Time.deltaTime;
        }
        if (Input.GetKey(KeyCode.DownArrow) && meuY > -meuLimite)
        {
            // Debug.Log("DOWN");
            meuY -= velocidade * Time.deltaTime;
        }
    }
}
