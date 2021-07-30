package com.unitec.listadinamica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /* Aqui iria en la de localiza amigos un servicio REST que nos invocara
        //(callback) de los usuarios del back end, pero ahora simplemente creamos unos
        usuario fake.

        var u1=Usuario()
        u1.email="primero@gmail.com"
        u1.nombre="Juan"
        u1.edad=21

        var u2=Usuario()
        u2.email="segundo@gmail.com"
        u2.nombre="Ana"
        u2.edad=19

        var u3=Usuario()
        u3.email="tercera@gmail.com"
        u3.nombre="Pedro"
        u3.edad=23

        var u4=Usuario()
        u4.email="cuarto@gmail.com"
        u4.nombre="Maria"
        u4.edad=24


        //Generamos la lista dinamica fake
        var usuarios= arrayListOf(u1,u2,u3,u4)
     */

        //Empezamos con retrofit
        GlobalScope.launch(Dispatchers.IO){
            //REcuerda que este disptachers IO es para conectarse en una tarea asincronica al back end
            var retrofit= Retrofit.Builder()
                .baseUrl("https://localiza-amigos2.herokuapp.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build()

            //Invocamos els ervicios
            var servicioUsuarios=retrofit.create(ServicioUsuario::class.java)
            var hacerRequest=servicioUsuarios.buscarLozalizados()
            var usuarios=hacerRequest.execute().body()!!


            launch(Dispatchers.Main){
                val usuarioAdapter=UsuarioAdapter{usuario ->adapterOnClick(usuario)  }

                //INvocamos el recuclerView
                val recyclerView:RecyclerView=findViewById(R.id.recycler_view)
                //Inyectamos el recycler
                recyclerView.adapter=usuarioAdapter

                usuarioAdapter.submitList(usuarios)
            }
        }








    }
   //Finalmente agregamos el metodo adapterOnClick, el cual aciva el onClick de cada
   fun adapterOnClick(usuario:Usuario) {
       //Aqui tendriamos que inyectarle ora vista para que nos lleve a esa vista
         var intent= Intent(this, DetallesActivity::class.java)
         intent.putExtra("usuario",usuario)
       startActivity(intent)
      Toast.makeText(this, usuario.email, Toast.LENGTH_LONG).show()
   }

}