package com.lukninja.safeguardpro.service.model

data class Epi(
    var id: Int = 0,
    var ca: Int = 0,
    var nome: String = "",
    var descricao: String = "",
    var instrucoes: String = "",
    var tipo: String = "",
    var validadeFabrica: String = "",
    var validadeUso: String = "",
)