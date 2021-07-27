package com.unitec.listadinamica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetallesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles)

       var usuario=    intent.extras?.getSerializable("usuario") as Usuario
       var detalleNombre= findViewById<TextView>(R.id.detallesNombre)
        var detallesEmail=findViewById<TextView>(R.id.detallesEmail)
        var detallesEdad=findViewById<TextView>(R.id.detallesEdad)
        detalleNombre.text=usuario.nombre
        detallesEmail.text=usuario.email
        detallesEdad.text=usuario.edad.toString()
    }
}