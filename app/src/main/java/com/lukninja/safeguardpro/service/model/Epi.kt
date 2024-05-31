package com.lukninja.safeguardpro.service.model

data class Epi(
    var id: Int = 0,
    var nome: String = "",
    var descricao: String = "",
    var instrucoes: String = "",
    var ca: String = "",
    var tipo: String = "",
    var subTipo: String = "",
    var validadeFabrica: String = "",
    var validadeUso: String = "",
)