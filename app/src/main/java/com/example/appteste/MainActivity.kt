package com.example.appteste

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

const val EXTRA_MESSAGE = "com.example.appteste.MESSAGE"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btCalcular = buttonCalcular
        val resultado = textViewResultado

        btCalcular.setOnClickListener{
            val nota1 = editTextNotaUm.text.toString().toDouble()
            val nota2 = editTextNotaDois.text.toString().toDouble()
            val media = (nota1+nota2)/2

            if(media >= 6){
                textViewResultado.setText("Você foi aprovado!"+"\n"+"Média: "+media+"\n"+"Parabéns :D")
                textViewResultado.setTextColor(Color.GREEN)
            }else{
                textViewResultado.setText("Você foi reprovado!"+"\n"+"Média: "+media+"\n"+"Que pena :(")
                textViewResultado.setTextColor(Color.RED)
            }
        }

    }


    fun sendMessage(view: View){
        //val editText = findViewById<EditText>(R.id.editText)
        val message = "Gomo chupa cu de goianinha"
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }
}