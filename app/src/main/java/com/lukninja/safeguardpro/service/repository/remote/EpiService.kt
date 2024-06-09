package com.lukninja.safeguardpro.service.repository.remote

import com.lukninja.safeguardpro.service.model.Epi
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path

interface EpiService {
    @GET("get_epis")
    suspend fun getEpis(): List<Epi>

    @GET("get_epi/{epi_id}")
    suspend fun getEpiById(@Path("epi_id") id: Int): Response<List<Epi>>

    @Multipart
    @POST("add_epi")
    suspend fun createEpi(
        @Part("ca") ca: RequestBody,
        @Part("nome") nome: RequestBody,
        @Part("descricao") descricao: RequestBody,
        @Part("instrucoes") instrucoes: RequestBody,
        @Part("tipo") tipo: RequestBody,
        @Part("validadeFabrica") validadeFabrica: RequestBody,
        @Part("validadeUso") validadeUso: RequestBody,
    ): Response<Epi>

    @Multipart
    @PUT("update_epi/{epi_id}")
    suspend fun updateEpi(
        @Path("epi_id") epiId: Int,
        @Part("ca") ca: RequestBody,
        @Part("nome") nome: RequestBody,
        @Part("descricao") descricao: RequestBody,
        @Part("instrucoes") instrucoes: RequestBody,
        @Part("tipo") tipo: RequestBody,
        @Part("validadeFabrica") validadeFabrica: RequestBody,
        @Part("validadeUso") validadeUso: RequestBody,
    ): Response<Epi>

    @DELETE("delete_epi/{epi_id}")
    suspend fun deleteEpiById(@Path("epi_id") id: Int): Response<Epi>
}