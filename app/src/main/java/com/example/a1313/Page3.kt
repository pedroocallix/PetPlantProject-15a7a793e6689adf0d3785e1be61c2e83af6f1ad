package com.example.a1313

import android.arch.lifecycle.Observer
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_page3.*

class Page3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page3)

        val viewModel = AtualizaViewModel
        val i = intent
        recebeNome.text=i.getStringExtra("nomeJogador")

        RetornaDados(viewModel.DadosBluetooth())
        viewModel.DadosBluetooth.observe(this, Observer {
           RetornaDados(viewModel.DadosBluetooth())

        })

        dicasButton.setOnClickListener {
            viewModel.EnviarDados('P')
        }
        configButton.setOnClickListener{
            viewModel.EnviarDados('Z')
        }
    }
    fun RetornaDados(str:String?)
    {
        Log.d("mer","recebendo-->"+str)
          if(str!=null && str.length>0 && str!="null") {

            val listaValores = str.split(";")
            mf_progress_bar_azul.progress = listaValores[0].toDouble().toInt()
            mf_progress_bar_amarelo.progress = listaValores[1].toDouble().toInt()
              Log.d("mer","pa"+mf_progress_bar_amarelo.progress)
        }

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

        //var intent:Intent=Intent (this, Dicas::class.java)
        //startActivity(intent)
    }

    fun ClickConfig (view: View) {

       // var intent:Intent=Intent ( this, Configuracoes::class.java)
        //startActivity(intent)
    }

}
