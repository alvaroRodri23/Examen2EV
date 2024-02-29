package com.example.examen2ev

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

private lateinit var nombre: EditText
private lateinit var valoracion: EditText
private lateinit var continuar: Button


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nombre= findViewById(R.id.EditTextnombre)
        valoracion= findViewById(R.id.EditTextvaloracion)
        continuar= findViewById(R.id.continuar)


        continuar.setOnClickListener {


            if(nombre.text.toString().isEmpty()|| valoracion.text.toString().isEmpty()){
                Toast.makeText(this@MainActivity,"RELLENA TODOS LOS CAMPOS",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

        intent= Intent(this,SecondActivity::class.java).apply {

            putExtra("nombreteclado", nombre.text.toString())
            putExtra("valoracionteclado", valoracion.text.toString())

        }
            startActivity(intent)
        }





    }
}