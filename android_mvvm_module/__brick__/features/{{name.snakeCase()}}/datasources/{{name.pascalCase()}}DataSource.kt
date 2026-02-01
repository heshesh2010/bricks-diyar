package com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.features.{{name.snakeCase()}}.datasources

import com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.core.helpers.Resource
import com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.features.{{name.snakeCase()}}.models.{{name.pascalCase()}}
import javax.inject.Inject

/**
 * Main data source for {{name.pascalCase()}} feature
 * Coordinates between remote and local data sources
 */
class {{name.pascalCase()}}DataSource @Inject constructor(
    {{#hasRemoteData}}private val remoteDataSource: {{name.pascalCase()}}RemoteDataSource{{/hasRemoteData}}{{#hasLocalData}}{{#hasRemoteData}},{{/hasRemoteData}}
    private val localDataSource: {{name.pascalCase()}}LocalDataSource{{/hasLocalData}}
) {

    /**
     * Fetch {{name.camelCase()}} list
     */
    suspend fun fetch{{name.pascalCase()}}(): Resource<List<{{name.pascalCase()}}>> {
        {{#hasRemoteData}}return remoteDataSource.fetch{{name.pascalCase()}}(){{/hasRemoteData}}{{^hasRemoteData}}// TODO: Implement local fetch
        return Resource.Error("Not implemented"){{/hasRemoteData}}
    }

}
