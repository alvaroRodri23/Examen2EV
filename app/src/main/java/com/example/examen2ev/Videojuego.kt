package com.example.examen2ev

class Videojuego (
    private var nombre: String,
    private var valoracion: Float,
    private var empresa: String,
    private var anio: Int

) {

    fun getNombre()= nombre

    fun getValoracion()= valoracion

    fun getEmpresa()= empresa

    fun getAnio()= anio


    override fun toString(): String {
        return "Videojuego(nombre='$nombre', valoracion=$valoracion, empresa='$empresa', anio=$anio)"
    }
}