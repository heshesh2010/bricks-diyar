package com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.features.{{name.snakeCase()}}.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.core.helpers.Resource
import com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.core.network.NetworkErrorHandler
import com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.core.network.NetworkHandler
import com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.features.{{name.snakeCase()}}.models.{{name.pascalCase()}}
import com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.features.{{name.snakeCase()}}.services.{{name.pascalCase()}}Service
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * MVI ViewModel for {{name.pascalCase()}} feature
 * Handles business logic and state management
 */
class {{name.pascalCase()}}ViewModel : ViewModel() {

    private val {{name.camelCase()}}Service = NetworkHandler.createService<{{name.pascalCase()}}Service>()

    // State
    private val _state = MutableStateFlow({{name.pascalCase()}}Contract.State())
    val state: StateFlow<{{name.pascalCase()}}Contract.State> = _state.asStateFlow()

    // Side Effects
    private val _effect = Channel<{{name.pascalCase()}}Contract.Effect>()
    val effect = _effect.receiveAsFlow()

    init {
        handleIntent({{name.pascalCase()}}Contract.Intent.Load{{name.pascalCase()}}s)
    }

    /**
     * Handle user intents
     */
    fun handleIntent(intent: {{name.pascalCase()}}Contract.Intent) {
        when (intent) {
            is {{name.pascalCase()}}Contract.Intent.Load{{name.pascalCase()}}s -> load{{name.pascalCase()}}s()
            is {{name.pascalCase()}}Contract.Intent.Select{{name.pascalCase()}} -> load{{name.pascalCase()}}Details(intent.{{name.camelCase()}}Id)
            is {{name.pascalCase()}}Contract.Intent.ClearSelected{{name.pascalCase()}} -> clearSelected{{name.pascalCase()}}()
            is {{name.pascalCase()}}Contract.Intent.Refresh -> refresh{{name.pascalCase()}}s()
            is {{name.pascalCase()}}Contract.Intent.ClearError -> clearError()
        }
    }

    private fun load{{name.pascalCase()}}s() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            
            try {
                val response = {{name.camelCase()}}Service.get{{name.pascalCase()}}s()
                if (response.isSuccessful) {
                    response.body()?.let { {{name.camelCase()}}s ->
                        _state.update { 
                            it.copy(
                                isLoading = false,
                                {{name.camelCase()}}List = {{name.camelCase()}}s,
                                error = null
                            ) 
                        }
                    } ?: run {
                        _state.update { 
                            it.copy(
                                isLoading = false,
                                error = "No data available"
                            ) 
                        }
                    }
                } else {
                    _state.update { 
                        it.copy(
                            isLoading = false,
                            error = "Error: ${response.code()}"
                        ) 
                    }
                }
            } catch (e: Exception) {
                _state.update { 
                    it.copy(
                        isLoading = false,
                        error = NetworkErrorHandler.getErrorMessage(e)
                    ) 
                }
                sendEffect({{name.pascalCase()}}Contract.Effect.ShowToast(NetworkErrorHandler.getErrorMessage(e)))
            }
        }
    }

    private fun load{{name.pascalCase()}}Details({{name.camelCase()}}Id: Int) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            
            try {
                val response = {{name.camelCase()}}Service.get{{name.pascalCase()}}ById({{name.camelCase()}}Id)
                if (response.isSuccessful) {
                    response.body()?.let { {{name.camelCase()}} ->
                        _state.update { 
                            it.copy(
                                isLoading = false,
                                selected{{name.pascalCase()}} = {{name.camelCase()}},
                                error = null
                            ) 
                        }
                    } ?: run {
                        _state.update { 
                            it.copy(
                                isLoading = false,
                                error = "{{name.pascalCase()}} not found"
                            ) 
                        }
                    }
                } else {
                    _state.update { 
                        it.copy(
                            isLoading = false,
                            error = "Error: ${response.code()}"
                        ) 
                    }
                }
            } catch (e: Exception) {
                _state.update { 
                    it.copy(
                        isLoading = false,
                        error = NetworkErrorHandler.getErrorMessage(e)
                    ) 
                }
                sendEffect({{name.pascalCase()}}Contract.Effect.ShowToast(NetworkErrorHandler.getErrorMessage(e)))
            }
        }
    }

    private fun clearSelected{{name.pascalCase()}}() {
        _state.update { it.copy(selected{{name.pascalCase()}} = null) }
    }

    private fun refresh{{name.pascalCase()}}s() {
        load{{name.pascalCase()}}s()
    }

    private fun clearError() {
        _state.update { it.copy(error = null) }
    }

    private fun sendEffect(effect: {{name.pascalCase()}}Contract.Effect) {
        viewModelScope.launch {
            _effect.send(effect)
        }
    }
}
