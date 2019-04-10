package com.example.a1313

import android.os.Handler
import android.os.Message
import android.util.Log
import java.lang.Exception
import java.nio.charset.Charset

class MHandler: Handler()
{
    override fun handleMessage(msg: Message) {

        val writeBuf = msg.obj as ByteArray
        val writeMessage = String(writeBuf, Charset.forName("UTF-8"))
        Log.d("mer", "O que veio" + writeMessage)
        try {
            val lista = writeMessage.split(";")
            val n = lista[0].toDouble() + 10
            Log.d("mer", "valor:" + n)
            AtualizaViewModel.DadosBluetooth(writeMessage)
        } catch (e: Exception) {
            Log.d("mer", "erro" + e)
        }
    }
}