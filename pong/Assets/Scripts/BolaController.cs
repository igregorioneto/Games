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
        if (transform.position.x >= limiteBola || transform.position.x <= -limiteBola)
        {
            SceneManager.LoadScene("Jogo");
        }
    }

    private void OnCollisionEnter2D(Collision2D other) 
    {
        AudioSource.PlayClipAtPoint(boing, cameraTransform.position);
    }
}
