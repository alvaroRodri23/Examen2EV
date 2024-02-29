package com.example.examen2ev

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

private lateinit var lista: TextView
private lateinit var atras: Button
private lateinit var db: Juegos


class SaveActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save)
        db= Juegos(this)



        lista = findViewById(R.id.textolista)
        atras = findViewById(R.id.atras)

        val listaJuegos = db.lectura()
        lista.text= listaJuegos.toString()
        listaJuegos.joinToString("\n")





        atras.setOnClickListener {

            intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }



    }

}