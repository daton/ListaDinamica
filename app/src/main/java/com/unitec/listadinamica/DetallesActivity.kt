package com.unitec.listadinamica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetallesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles)

    var usuario=    intent.extras?.getSerializable("usuario") as Usuario
       var detalleNombre= findViewById<TextView>(R.id.detalleNombre)
        detalleNombre.text=usuario.nombre
    }
}