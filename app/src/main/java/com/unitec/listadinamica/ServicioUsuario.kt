package com.unitec.listadinamica

import retrofit2.Call
import retrofit2.http.GET


interface ServicioUsuario {
    @GET("api/localizaciones")
    fun buscarLozalizados(): Call<ArrayList<Usuario>>
}