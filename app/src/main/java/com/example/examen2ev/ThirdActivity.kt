package com.example.examen2ev

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

private lateinit var nombretexto: TextView
private lateinit var valoraciontexto: TextView
private lateinit var empresatexto: TextView
private lateinit var aniotexto: TextView
private lateinit var atras: Button
private lateinit var guardar: Button



class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        val db = Juegos(this)


        nombretexto= findViewById(R.id.textonombre)
        valoraciontexto= findViewById(R.id.textovaloracion)
        empresatexto= findViewById(R.id.textoempresa)
        aniotexto= findViewById(R.id.textoanio)
        guardar = findViewById(R.id.guardar)
        atras= findViewById(R.id.atras)

        nombretexto.text= intent.getStringExtra("nombreteclado")
        valoraciontexto.text = intent.getStringExtra("valoracionteclado")
        empresatexto.text= intent.getStringExtra("empresateclado")
        aniotexto.text = intent.getStringExtra("anioteclado")



        guardar.setOnClickListener {
            intent= Intent(this,SaveActivity::class.java).apply{

            }
            db.escribir(Videojuego(nombretexto.text.toString(), valoraciontexto.text.toString().toFloat(),empresatexto.text.toString(),aniotexto.text.toString().toInt()))

            startActivity(intent)
        }


        atras.setOnClickListener {

            intent= Intent(this,MainActivity::class.java)

            startActivity(intent)
        }

    }
}