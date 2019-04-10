package com.example.a1313

import android.arch.lifecycle.Observer
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_page3.*

class Page3 : AppCompatActivity() {
    val viewModel = AtualizaViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page3)


        val i = intent
        recebeNome.text=i.getStringExtra("nomeJogador")

        RetornaDados(viewModel.DadosBluetooth())
        viewModel.DadosBluetooth.observe(this, Observer {
            RetornaDados(viewModel.DadosBluetooth())
        })
    }
    fun RetornaDados(str:String)
    {
        val listaValores=str.split(";")
        mf_progress_bar_azul.progress=listaValores[0].toInt()
        mf_progress_bar_amarelo.progress=listaValores[1].toInt()


    }


    fun ClickUmidade (view: View){
        var intent:Intent=Intent (this, PageUmidade::class.java)
        startActivity(intent)

    }

    fun ClickUV (view: View){
        var intent:Intent=Intent(this, PageUV::class.java)
        startActivity(intent)
    }

    fun ClickDicas (view: View) {
        viewModel.EnviarDados('P')
        //var intent:Intent=Intent (this, Dicas::class.java)
        //startActivity(intent)
    }

    fun ClickConfig (view: View) {
        viewModel.EnviarDados('Z')
       // var intent:Intent=Intent ( this, Configuracoes::class.java)
        //startActivity(intent)
    }

}
