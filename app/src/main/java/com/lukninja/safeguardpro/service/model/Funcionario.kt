package com.lukninja.safeguardpro.service.model

data class Funcionario(
    var id: Int = 0,
    var adm: Boolean = false,
    var nome: String = "",
    var sobrenome: String = "",
    var ctps: Int = 0,
    var cargo:String = "",
    var senha: String = "",
)