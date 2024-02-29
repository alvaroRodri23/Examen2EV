package com.example.examen2ev

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

private lateinit var empresa:EditText
private lateinit var anio:EditText
private lateinit var continuar2: Button
private lateinit var nombretexto: TextView
private lateinit var valoraciontexto: TextView
private lateinit var atras: Button


class SecondActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        nombretexto= findViewById(R.id.textonombre2)
        valoraciontexto= findViewById(R.id.textovaloracion2)
        empresa= findViewById(R.id.EditTextempresa)
        anio= findViewById(R.id.EditTextanio)
        continuar2= findViewById(R.id.continuar2)
        atras= findViewById(R.id.atras)


        nombretexto.text= intent.getStringExtra("nombreteclado")
        valoraciontexto.text = intent.getStringExtra("valoracionteclado")

        continuar2.setOnClickListener {

            if(empresa.text.toString().isEmpty()|| anio.text.toString().isEmpty()){
                Toast.makeText(this@SecondActivity,"RELLENA TODOS LOS CAMPOS", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            intent= Intent(this,ThirdActivity::class.java).apply {
                    putExtra("nombreteclado", nombretexto.text.toString())
                    putExtra("valoracionteclado", valoraciontexto.text.toString())
                    putExtra("empresateclado", empresa.text.toString())
                    putExtra("anioteclado", anio.text.toString())

            }
            startActivity(intent)
        }

        atras.setOnClickListener {
            intent= Intent(this,MainActivity::class.java)

            startActivity(intent)
        }

    }
}