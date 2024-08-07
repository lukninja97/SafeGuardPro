package com.lukninja.safeguardpro.service.repository.remote

import com.lukninja.safeguardpro.service.model.Funcionario
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path

interface FuncionarioService {
    
    @GET("get_funcionarios")
    suspend fun getFuncionarios(): List<Funcionario>

    @GET("get_funcionario/{funcionario_id}")
    suspend fun getFuncionarioById(@Path("funcionario_id") id: Int): Response<List<Funcionario>>

    @Multipart
    @POST("add_funcionario")
    suspend fun createFuncionario(
        @Part("adm") admin: RequestBody,
        @Part("nome") nome: RequestBody,
        @Part("sobrenome") sobrenome: RequestBody,
        @Part("ctps") ctps: RequestBody,
        @Part("cargo") cargo: RequestBody,
    ): Response<Funcionario>

    @Multipart
    @PUT("update_funcionario/{funcionario_id}")
    suspend fun updateFuncionario(
        @Path("funcionario_id") funcionarioId: Int,
        @Part("adm") admin: RequestBody,
        @Part("nome") nome: RequestBody,
        @Part("sobrenome") sobrenome: RequestBody,
        @Part("ctps") ctps: RequestBody,
        @Part("cargo") cargo: RequestBody,
    ): Response<Funcionario>

    @DELETE("delete_funcionario/{funcionario_id}")
    suspend fun deleteFuncionarioById(@Path("funcionario_id") id: Int): Response<Funcionario>
}