package com.example.features.{{name.snakeCase()}}.services

import com.example.features.{{name.snakeCase()}}.models.{{name.pascalCase()}}
import retrofit2.http.*

/**
 * Service interface for {{name.pascalCase()}} API calls
 */
interface {{name.pascalCase()}}Service {
    
    @GET("{{name.snakeCase()}}")
    suspend fun get{{name.pascalCase()}}List(): List<{{name.pascalCase()}}>
    
    @GET("{{name.snakeCase()}}/{id}")
    suspend fun get{{name.pascalCase()}}ById(@Path("id") id: String): {{name.pascalCase()}}
    
    @POST("{{name.snakeCase()}}")
    suspend fun create{{name.pascalCase()}}(@Body {{name.camelCase()}}: {{name.pascalCase()}}): {{name.pascalCase()}}
    
    @PUT("{{name.snakeCase()}}/{id}")
    suspend fun update{{name.pascalCase()}}(
        @Path("id") id: String,
        @Body {{name.camelCase()}}: {{name.pascalCase()}}
    ): {{name.pascalCase()}}
    
    @DELETE("{{name.snakeCase()}}/{id}")
    suspend fun delete{{name.pascalCase()}}(@Path("id") id: String)
}
