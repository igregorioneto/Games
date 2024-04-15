using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class BolaController : MonoBehaviour
{
    private Vector2 minhaVelocidade;
    public Rigidbody2D meuRB;
    public float velocidade = 5f;
    public float limiteBola = 12;

    public AudioClip boing;
    public Transform cameraTransform;

    public float delay = 2f;
    public bool jogoIniciado = true;

    
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        delay -= Time.deltaTime;
        if (delay <= 0 && !jogoIniciado)
        {
            jogoIniciado = true;
            IniciarJogo();
        }

        if (transform.position.x >= limiteBola || transform.position.x <= -limiteBola)
        {
            SceneManager.LoadScene("Jogo");
        }
    }

    public void IniciarJogo()
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

    private void OnCollisionEnter2D(Collision2D other) 
    {
        AudioSource.PlayClipAtPoint(boing, cameraTransform.position);
    }
}
