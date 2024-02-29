package com.example.examen2ev

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

//class SaveActivity : AppCompatActivity() {
  //  override fun onCreate(savedInstanceState: Bundle?) {
    //    super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_main)
        //Creamos la instancia de la clase DatabaseHelper, nos va a permitir acceder a los recursos de la aplicación
        //val dbHelper = DatabaseHelper(this)


    //}
//}

// Clase DatabaseHelper
class Juegos(context: Context) : SQLiteOpenHelper(context, DATABASE, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE = "JuegosComprados"
        private const val TABLA_JUEGOS = "juegos"
        private const val COLUMN_NAME = "nombre"
        private const val COLUMN_VALORACION = "valoracion"
        private const val COLUMN_EMPRESA = "empresa"
        private const val COLUMN_ANIO = "anio"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = "CREATE TABLE $TABLA_JUEGOS ($COLUMN_NAME TEXT, $COLUMN_VALORACION FLOAT,$COLUMN_EMPRESA TEXT,$COLUMN_ANIO INTEGER)"
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLA_JUEGOS")
        onCreate(db)
    }

    fun escribir(videojuego: Videojuego){
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NAME, videojuego.getNombre())
            put(COLUMN_VALORACION, videojuego.getValoracion())
            put(COLUMN_EMPRESA, videojuego.getEmpresa())
            put(COLUMN_ANIO, videojuego.getAnio())
        }
        db.insert(TABLA_JUEGOS, null, values)
        db.close()
    }


    @SuppressLint("Range")
    fun lectura(): ArrayList<Videojuego> {
        val lectura = ArrayList<Videojuego>()
        val selectQuery = "SELECT * FROM $TABLA_JUEGOS"
        val db = this.readableDatabase
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor.moveToFirst()) {
            do {
                val nombre = cursor.getString(cursor.getColumnIndex(COLUMN_NAME))
                val valoracion = cursor.getFloat(cursor.getColumnIndex(COLUMN_VALORACION))
                val empresa = cursor.getString(cursor.getColumnIndex(COLUMN_EMPRESA))
                val anio = cursor.getInt(cursor.getColumnIndex(COLUMN_ANIO))
                lectura.add(Videojuego(nombre, valoracion,empresa,anio))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return lectura
    }

}


