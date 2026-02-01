package com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.features.{{name.snakeCase()}}.datasources

import com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.core.bases.BaseDataSource
import com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.core.helpers.Resource
import com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.core.network.connection.ConnectionCheck
import com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.features.{{name.snakeCase()}}.models.{{name.pascalCase()}}
import com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.features.{{name.snakeCase()}}.services.{{name.pascalCase()}}Service
import javax.inject.Inject

/**
 * Remote data source for {{name.pascalCase()}} feature
 * Handles API calls and remote data operations
 * Extends BaseDataSource for safe API call handling
 */
class {{name.pascalCase()}}RemoteDataSource @Inject constructor(
    private val api: {{name.pascalCase()}}Service,
    connectionCheck: ConnectionCheck
) : BaseDataSource(connectionCheck) {

    /**
     * Fetch {{name.camelCase()}} list from remote API
     */
    suspend fun fetch{{name.pascalCase()}}(): Resource<List<{{name.pascalCase()}}>> {
        return safeApiCall {
            api.get{{name.pascalCase()}}()
        }
    }
}
