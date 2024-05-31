package com.lukninja.safeguardpro.service.model

data class Funcionario(
    var id: Int = 0,
    var nome: String = "",
    var cpf: String = "",
    var email: String = "",
    var cargo:String = "",
    var admin: Boolean = false,
    var ct: Int = 0,
)