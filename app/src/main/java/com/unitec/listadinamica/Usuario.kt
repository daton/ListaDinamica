package com.unitec.listadinamica

import java.io.Serializable
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Usuario: Serializable{
    var nombre:String?=null
    var email:String?=null
    var nickname:String?=null
    var localizaciones:ArrayList<Localizacion>?=null
}