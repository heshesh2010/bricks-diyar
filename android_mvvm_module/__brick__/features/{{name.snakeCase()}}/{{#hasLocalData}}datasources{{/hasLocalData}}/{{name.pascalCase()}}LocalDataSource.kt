package com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.features.{{name.snakeCase()}}.datasources

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.core.shared_preferences_data_source.SharedPreferencesDataSource
import com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.features.{{name.snakeCase()}}.models.{{name.pascalCase()}}
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Local data source for {{name.pascalCase()}} feature
 * Handles local data storage using DataStore and SharedPreferences
 */
class {{name.pascalCase()}}LocalDataSource @Inject constructor(
    private val context: Context,
    private val sharedPreferencesDataSource: SharedPreferencesDataSource
) {

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "{{name.snakeCase()}}_preferences")
        private val {{name.constantCase()}}_LIST_KEY = stringPreferencesKey("{{name.snakeCase()}}_list")
        private val SELECTED_{{name.constantCase()}}_KEY = stringPreferencesKey("selected_{{name.snakeCase()}}")
    }

    private val gson = Gson()

    /**
     * Save {{name.camelCase()}} list to local storage
     */
    suspend fun save{{name.pascalCase()}}List({{name.camelCase()}}s: List<{{name.pascalCase()}}>) {
        context.dataStore.edit { preferences ->
            val json = gson.toJson({{name.camelCase()}}s)
            preferences[{{name.constantCase()}}_LIST_KEY] = json
        }
    }

    /**
     * Get {{name.camelCase()}} list from local storage
     */
    fun get{{name.pascalCase()}}List(): Flow<List<{{name.pascalCase()}}>> {
        return context.dataStore.data.map { preferences ->
            val json = preferences[{{name.constantCase()}}_LIST_KEY]
            if (json != null) {
                gson.fromJson(json, Array<{{name.pascalCase()}}>::class.java).toList()
            } else {
                emptyList()
            }
        }
    }

    /**
     * Save selected {{name.camelCase()}} to local storage
     */
    suspend fun saveSelected{{name.pascalCase()}}({{name.camelCase()}}: {{name.pascalCase()}}) {
        context.dataStore.edit { preferences ->
            val json = gson.toJson({{name.camelCase()}})
            preferences[SELECTED_{{name.constantCase()}}_KEY] = json
        }
    }

    /**
     * Get selected {{name.camelCase()}} from local storage
     */
    fun getSelected{{name.pascalCase()}}(): Flow<{{name.pascalCase()}}?> {
        return context.dataStore.data.map { preferences ->
            val json = preferences[SELECTED_{{name.constantCase()}}_KEY]
            if (json != null) {
                gson.fromJson(json, {{name.pascalCase()}}::class.java)
            } else {
                null
            }
        }
    }

    /**
     * Clear all {{name.camelCase()}} data from local storage
     */
    suspend fun clear{{name.pascalCase()}}Data() {
        context.dataStore.edit { preferences ->
            preferences.remove({{name.constantCase()}}_LIST_KEY)
            preferences.remove(SELECTED_{{name.constantCase()}}_KEY)
        }
    }
}
