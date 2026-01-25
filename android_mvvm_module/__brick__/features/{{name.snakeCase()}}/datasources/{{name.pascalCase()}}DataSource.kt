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
    suspend fun fetch{{name.pascalCase()}}s(): Resource<List<{{name.pascalCase()}}>> {
        {{#hasRemoteData}}return remoteDataSource.fetch{{name.pascalCase()}}s(){{/hasRemoteData}}{{^hasRemoteData}}// TODO: Implement local fetch
        return Resource.Error("Not implemented"){{/hasRemoteData}}
    }

    /**
     * Fetch {{name.camelCase()}} by ID
     */
    suspend fun fetch{{name.pascalCase()}}ById({{name.camelCase()}}Id: Int): Resource<{{name.pascalCase()}}> {
        {{#hasRemoteData}}return remoteDataSource.fetch{{name.pascalCase()}}ById({{name.camelCase()}}Id){{/hasRemoteData}}{{^hasRemoteData}}// TODO: Implement local fetch
        return Resource.Error("Not implemented"){{/hasRemoteData}}
    }

    /**
     * Create new {{name.camelCase()}}
     */
    suspend fun create{{name.pascalCase()}}({{name.camelCase()}}: {{name.pascalCase()}}): Resource<{{name.pascalCase()}}> {
        {{#hasRemoteData}}return remoteDataSource.create{{name.pascalCase()}}({{name.camelCase()}}){{/hasRemoteData}}{{^hasRemoteData}}// TODO: Implement local create
        return Resource.Error("Not implemented"){{/hasRemoteData}}
    }

    /**
     * Update existing {{name.camelCase()}}
     */
    suspend fun update{{name.pascalCase()}}({{name.camelCase()}}Id: Int, {{name.camelCase()}}: {{name.pascalCase()}}): Resource<{{name.pascalCase()}}> {
        {{#hasRemoteData}}return remoteDataSource.update{{name.pascalCase()}}({{name.camelCase()}}Id, {{name.camelCase()}}){{/hasRemoteData}}{{^hasRemoteData}}// TODO: Implement local update
        return Resource.Error("Not implemented"){{/hasRemoteData}}
    }

    /**
     * Delete {{name.camelCase()}}
     */
    suspend fun delete{{name.pascalCase()}}({{name.camelCase()}}Id: Int): Resource<Unit> {
        {{#hasRemoteData}}return remoteDataSource.delete{{name.pascalCase()}}({{name.camelCase()}}Id){{/hasRemoteData}}{{^hasRemoteData}}// TODO: Implement local delete
        return Resource.Error("Not implemented"){{/hasRemoteData}}
    }
}
