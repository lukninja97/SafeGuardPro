package com.lukninja.safeguardpro.service.repository

import android.content.Context
import com.lukninja.safeguardpro.service.model.Entrega
import com.lukninja.safeguardpro.service.repository.remote.EntregaService
import com.lukninja.safeguardpro.service.repository.remote.RetrofitClient
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody

class EntregaRepository(context: Context) {
    private val mRemote = RetrofitClient.createService(EntregaService::class.java)

    private val entregaEmpty = Entrega(0, 0, 0, "", "", "", "")

    suspend fun insertEntrega(entrega: Entrega): Entrega {
        return mRemote.createEntrega(
            idFuncionario = entrega.idFuncionario.toString().toRequestBody("text/plain".toMediaTypeOrNull()),
            idEpi = entrega.idEpi.toString().toRequestBody("text/plain".toMediaTypeOrNull()),
            dataEntrega = entrega.dataEntrega.toRequestBody("text/plain".toMediaTypeOrNull()),
            dataVencimento = entrega.dataVencimento.toRequestBody("text/plain".toMediaTypeOrNull()),
            dataDevolucao = entrega.dataDevolucao.toRequestBody("text/plain".toMediaTypeOrNull()),
            status = entrega.status.toRequestBody("text/plain".toMediaTypeOrNull()),
        ).body() ?: entregaEmpty
    }

    suspend fun getEntrega(id: Int): Entrega {
        val response = mRemote.getEntregaById(id)
        return if (response.isSuccessful) {
            response.body()?.first() ?: entregaEmpty
        } else {
            entregaEmpty
        }
    }

    suspend fun getEntregas(): List<Entrega> {
        return mRemote.getEntregas()
    }

    suspend fun updateEntrega(id: Int, entrega: Entrega): Entrega {
        return mRemote.updateEntrega(
            idFuncionario = entrega.idFuncionario.toString().toRequestBody("text/plain".toMediaTypeOrNull()),
            idEpi = entrega.idEpi.toString().toRequestBody("text/plain".toMediaTypeOrNull()),
            dataEntrega = entrega.dataEntrega.toRequestBody("text/plain".toMediaTypeOrNull()),
            dataVencimento = entrega.dataVencimento.toRequestBody("text/plain".toMediaTypeOrNull()),
            dataDevolucao = entrega.dataDevolucao.toRequestBody("text/plain".toMediaTypeOrNull()),
            status = entrega.status.toRequestBody("text/plain".toMediaTypeOrNull()),
            entregaId = id
        ).body() ?: entregaEmpty
    }

    suspend fun deleteEntrega(id: Int): Boolean {
        return mRemote.deleteEntregaById(id).isSuccessful
    }
}