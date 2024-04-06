using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class RaqueteController : MonoBehaviour
{
    private Vector3 _minhaPosicao;
    public float meuY;
    // Start is called before the first frame update
    void Start()
    {
        _minhaPosicao = transform.position;
    }

    // Update is called once per frame
    void Update()
    {
        _minhaPosicao.y = meuY;
       transform.position = _minhaPosicao;
    }
}
