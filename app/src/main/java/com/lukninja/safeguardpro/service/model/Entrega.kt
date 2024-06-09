package com.lukninja.safeguardpro.service.model

data class Entrega(
    var id: Int = 0,
    var idFuncionario: Int = 0,
    var idEpi: Int = 0,
    var dataEntrega: String,
    var dataVencimento: String,
    var dataDevolucao: String,
    var status: String = "ENTREGUE - DEVOLVIDO - VENCIDOS",
)
