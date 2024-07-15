package com.lukninja.safeguardpro.service.repository

import android.content.Context
import com.lukninja.safeguardpro.service.model.Funcionario
import com.lukninja.safeguardpro.service.repository.remote.FuncionarioService
import com.lukninja.safeguardpro.service.repository.remote.RetrofitClient
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody

class FuncionarioRepository(context: Context) {
    private val mRemote = RetrofitClient.createService(FuncionarioService::class.java)

    private val funcionarioEmpty = Funcionario(0, false, "", "", 0, "", "")

    suspend fun insertFuncionario(funcionario: Funcionario): Funcionario {
        return mRemote.createFuncionario(
            admin = funcionario.adm.toString().toRequestBody("text/plain".toMediaTypeOrNull()),
            nome = funcionario.nome.toRequestBody("text/plain".toMediaTypeOrNull()),
            sobrenome = funcionario.sobrenome.toRequestBody("text/plain".toMediaTypeOrNull()),
            ctps = funcionario.ctps.toString().toRequestBody("text/plain".toMediaTypeOrNull()),
            cargo = funcionario.cargo.toRequestBody("text/plain".toMediaTypeOrNull()),
        ).body() ?: funcionarioEmpty
    }

    suspend fun getFuncionario(id: Int): Funcionario {
        val response = mRemote.getFuncionarioById(id)
        return if (response.isSuccessful) {
            response.body()?.first() ?: funcionarioEmpty
        } else {
            funcionarioEmpty
        }
    }

    suspend fun getFuncionarios(): List<Funcionario> {
        return mRemote.getFuncionarios()
    }

    suspend fun updateFuncionario(id: Int, funcionario: Funcionario): Funcionario {
        return mRemote.updateFuncionario(
            admin = funcionario.adm.toString().toRequestBody("text/plain".toMediaTypeOrNull()),
            nome = funcionario.nome.toRequestBody("text/plain".toMediaTypeOrNull()),
            sobrenome = funcionario.sobrenome.toRequestBody("text/plain".toMediaTypeOrNull()),
            ctps = funcionario.ctps.toString().toRequestBody("text/plain".toMediaTypeOrNull()),
            cargo = funcionario.cargo.toRequestBody("text/plain".toMediaTypeOrNull()),
            funcionarioId = id
        ).body() ?: funcionarioEmpty
    }

    suspend fun deleteFuncionario(id: Int): Boolean {
        return mRemote.deleteFuncionarioById(id).isSuccessful
    }
}