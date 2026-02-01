package com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.features.{{name.snakeCase()}}.services
import com.{{organization.snakeCase()}}.core.models.ApiResponse
import com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.features.{{name.snakeCase()}}.models.{{name.pascalCase()}}
import retrofit2.Response
import retrofit2.http.*

/**
 * Service interface for {{name.pascalCase()}} API endpoints
 */
interface {{name.pascalCase()}}Service {

    @GET("{{name.snakeCase()}}")
    suspend fun get{{name.pascalCase()}}(): Response<ApiResponse<List<{{name.pascalCase()}}>>>

}
