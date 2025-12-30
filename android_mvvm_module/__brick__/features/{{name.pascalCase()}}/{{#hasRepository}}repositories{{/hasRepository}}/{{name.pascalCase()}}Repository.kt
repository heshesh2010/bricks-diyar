package com.example.features.{{name.snakeCase()}}.repositories

import com.example.features.{{name.snakeCase()}}.models.{{name.pascalCase()}}
{{#useFlow}}import kotlinx.coroutines.flow.Flow{{/useFlow}}
{{#useLiveData}}import androidx.lifecycle.LiveData{{/useLiveData}}

/**
 * Repository interface for {{name.pascalCase()}}
 */
interface {{name.pascalCase()}}Repository {
    {{#useFlow}}
    suspend fun get{{name.pascalCase()}}List(): Flow<List<{{name.pascalCase()}}>?>
    
    suspend fun get{{name.pascalCase()}}ById(id: String): Flow<{{name.pascalCase()}}?>
    
    suspend fun create{{name.pascalCase()}}({{name.camelCase()}}: {{name.pascalCase()}}): Flow<{{name.pascalCase()}}?>
    
    suspend fun update{{name.pascalCase()}}(id: String, {{name.camelCase()}}: {{name.pascalCase()}}): Flow<{{name.pascalCase()}}?>
    
    suspend fun delete{{name.pascalCase()}}(id: String): Flow<Boolean>
    {{/useFlow}}
    {{#useLiveData}}
    fun get{{name.pascalCase()}}List(): LiveData<List<{{name.pascalCase()}}>?>
    
    fun get{{name.pascalCase()}}ById(id: String): LiveData<{{name.pascalCase()}}?>
    
    suspend fun create{{name.pascalCase()}}({{name.camelCase()}}: {{name.pascalCase()}}): LiveData<{{name.pascalCase()}}?>
    
    suspend fun update{{name.pascalCase()}}(id: String, {{name.camelCase()}}: {{name.pascalCase()}}): LiveData<{{name.pascalCase()}}?>
    
    suspend fun delete{{name.pascalCase()}}(id: String): LiveData<Boolean>
    {{/useLiveData}}
}
