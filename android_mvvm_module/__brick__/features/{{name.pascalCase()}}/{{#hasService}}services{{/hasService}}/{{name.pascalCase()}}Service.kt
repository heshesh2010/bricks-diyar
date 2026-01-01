package com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.features.{{name.snakeCase()}}.services

import com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.features.{{name.snakeCase()}}.models.{{name.pascalCase()}}
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface {{name.pascalCase()}}Service {

    @GET("{{name.snakeCase()}}")
    suspend fun get{{name.pascalCase()}}s(): Response<List<{{name.pascalCase()}}>>

    @GET("{{name.snakeCase()}}/{id}")
    suspend fun get{{name.pascalCase()}}ById(@Path("id") id: Int): Response<{{name.pascalCase()}}>
}
