package com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.features.{{name.snakeCase()}}.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.core.helpers.Resource
import com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.core.network.NetworkErrorHandler
import com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.core.network.NetworkHandler
import com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.features.{{name.snakeCase()}}.models.{{name.pascalCase()}}
import com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.features.{{name.snakeCase()}}.services.{{name.pascalCase()}}Service
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class {{name.pascalCase()}}ViewModel : ViewModel() {

    private val {{name.camelCase()}}Service = NetworkHandler.createService<{{name.pascalCase()}}Service>()

    private val _{{name.camelCase()}}sState = MutableStateFlow<Resource<List<{{name.pascalCase()}}>>>(Resource.Loading())
    val {{name.camelCase()}}sState: StateFlow<Resource<List<{{name.pascalCase()}}>>> = _{{name.camelCase()}}sState.asStateFlow()

    private val _selected{{name.pascalCase()}}State = MutableStateFlow<Resource<{{name.pascalCase()}}>?>(null)
    val selected{{name.pascalCase()}}State: StateFlow<Resource<{{name.pascalCase()}}>?> = _selected{{name.pascalCase()}}State.asStateFlow()

    init {
        get{{name.pascalCase()}}s()
    }

    fun get{{name.pascalCase()}}s() {
        viewModelScope.launch {
            _{{name.camelCase()}}sState.value = Resource.Loading()
            try {
                val response = {{name.camelCase()}}Service.get{{name.pascalCase()}}s()
                if (response.isSuccessful) {
                    response.body()?.let { {{name.camelCase()}}s ->
                        _{{name.camelCase()}}sState.value = Resource.Success({{name.camelCase()}}s)
                    } ?: run {
                        _{{name.camelCase()}}sState.value = Resource.Error("No data available")
                    }
                } else {
                    _{{name.camelCase()}}sState.value = Resource.Error("Error: ${response.code()}")
                }
            } catch (e: Exception) {
                _{{name.camelCase()}}sState.value = Resource.Error(NetworkErrorHandler.getErrorMessage(e))
            }
        }
    }

    fun get{{name.pascalCase()}}ById({{name.camelCase()}}Id: Int) {
        viewModelScope.launch {
            _selected{{name.pascalCase()}}State.value = Resource.Loading()
            try {
                val response = {{name.camelCase()}}Service.get{{name.pascalCase()}}ById({{name.camelCase()}}Id)
                if (response.isSuccessful) {
                    response.body()?.let { {{name.camelCase()}} ->
                        _selected{{name.pascalCase()}}State.value = Resource.Success({{name.camelCase()}})
                    } ?: run {
                        _selected{{name.pascalCase()}}State.value = Resource.Error("{{name.pascalCase()}} not found")
                    }
                } else {
                    _selected{{name.pascalCase()}}State.value = Resource.Error("Error: ${response.code()}")
                }
            } catch (e: Exception) {
                _selected{{name.pascalCase()}}State.value = Resource.Error(NetworkErrorHandler.getErrorMessage(e))
            }
        }
    }

    fun clearSelected{{name.pascalCase()}}() {
        _selected{{name.pascalCase()}}State.value = null
    }
}
