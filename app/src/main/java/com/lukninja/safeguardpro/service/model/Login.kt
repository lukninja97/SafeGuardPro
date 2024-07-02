package com.lukninja.safeguardpro.service.model

object Login {

    var userId = 0
    var userCtps = 0
    var userAdm = false

    fun userConected(id: Int, ctps: Int, adm: Boolean) {
        userId = id
        userCtps = ctps
        userAdm = adm
    }
}