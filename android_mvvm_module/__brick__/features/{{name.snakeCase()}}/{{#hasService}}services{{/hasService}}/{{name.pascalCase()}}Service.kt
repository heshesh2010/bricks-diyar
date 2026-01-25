package com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.features.{{name.snakeCase()}}.services

import com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.features.{{name.snakeCase()}}.models.{{name.pascalCase()}}
import retrofit2.Response
import retrofit2.http.*

/**
 * Service interface for {{name.pascalCase()}} API endpoints
 */
interface {{name.pascalCase()}}Service {

    @GET("{{name.snakeCase()}}")
    suspend fun get{{name.pascalCase()}}(): Response<List<{{name.pascalCase()}}>>

    @GET("{{name.snakeCase()}}/{id}")
    suspend fun get{{name.pascalCase()}}ById(@Path("id") id: Int): Response<{{name.pascalCase()}}>

    @POST("{{name.snakeCase()}}")
    suspend fun create{{name.pascalCase()}}(@Body {{name.camelCase()}}: {{name.pascalCase()}}): Response<{{name.pascalCase()}}>

    @PUT("{{name.snakeCase()}}/{id}")
    suspend fun update{{name.pascalCase()}}(
        @Path("id") id: Int,
        @Body {{name.camelCase()}}: {{name.pascalCase()}}
    ): Response<{{name.pascalCase()}}>

    @DELETE("{{name.snakeCase()}}/{id}")
    suspend fun delete{{name.pascalCase()}}(@Path("id") id: Int): Response<Unit>
}
