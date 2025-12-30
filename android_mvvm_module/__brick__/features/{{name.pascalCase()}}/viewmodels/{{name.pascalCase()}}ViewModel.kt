package com.example.features.{{name.snakeCase()}}.viewmodels

import androidx.lifecycle.ViewModel
{{#useFlow}}import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch{{/useFlow}}
{{#useLiveData}}import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData{{/useLiveData}}
import com.example.features.{{name.snakeCase()}}.models.{{name.pascalCase()}}
{{#hasRepository}}import com.example.features.{{name.snakeCase()}}.repositories.{{name.pascalCase()}}Repository{{/hasRepository}}

/**
 * ViewModel for {{name.pascalCase()}}
 */
class {{name.pascalCase()}}ViewModel(
    {{#hasRepository}}private val repository: {{name.pascalCase()}}Repository{{/hasRepository}}
) : ViewModel() {
    
    {{#useFlow}}
    private val _{{name.camelCase()}}List = MutableStateFlow<List<{{name.pascalCase()}}>>(emptyList())
    val {{name.camelCase()}}List: StateFlow<List<{{name.pascalCase()}}>> = _{{name.camelCase()}}List.asStateFlow()
    
    private val _selected{{name.pascalCase()}} = MutableStateFlow<{{name.pascalCase()}}?>(null)
    val selected{{name.pascalCase()}}: StateFlow<{{name.pascalCase()}}?> = _selected{{name.pascalCase()}}.asStateFlow()
    
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
    
    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()
    
    fun load{{name.pascalCase()}}List() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                {{#hasRepository}}
                repository.get{{name.pascalCase()}}List().collect { list ->
                    _{{name.camelCase()}}List.value = list ?: emptyList()
                }
                {{/hasRepository}}
                {{^hasRepository}}
                // TODO: Implement data loading
                {{/hasRepository}}
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }
    
    fun load{{name.pascalCase()}}ById(id: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                {{#hasRepository}}
                repository.get{{name.pascalCase()}}ById(id).collect { item ->
                    _selected{{name.pascalCase()}}.value = item
                }
                {{/hasRepository}}
                {{^hasRepository}}
                // TODO: Implement data loading
                {{/hasRepository}}
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }
    
    fun create{{name.pascalCase()}}({{name.camelCase()}}: {{name.pascalCase()}}) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                {{#hasRepository}}
                repository.create{{name.pascalCase()}}({{name.camelCase()}}).collect { created ->
                    created?.let {
                        load{{name.pascalCase()}}List()
                    }
                }
                {{/hasRepository}}
                {{^hasRepository}}
                // TODO: Implement creation
                {{/hasRepository}}
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }
    
    fun update{{name.pascalCase()}}(id: String, {{name.camelCase()}}: {{name.pascalCase()}}) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                {{#hasRepository}}
                repository.update{{name.pascalCase()}}(id, {{name.camelCase()}}).collect { updated ->
                    updated?.let {
                        load{{name.pascalCase()}}List()
                    }
                }
                {{/hasRepository}}
                {{^hasRepository}}
                // TODO: Implement update
                {{/hasRepository}}
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }
    
    fun delete{{name.pascalCase()}}(id: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                {{#hasRepository}}
                repository.delete{{name.pascalCase()}}(id).collect { success ->
                    if (success) {
                        load{{name.pascalCase()}}List()
                    }
                }
                {{/hasRepository}}
                {{^hasRepository}}
                // TODO: Implement deletion
                {{/hasRepository}}
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }
    {{/useFlow}}
    {{#useLiveData}}
    private val _{{name.camelCase()}}List = MutableLiveData<List<{{name.pascalCase()}}>>()
    val {{name.camelCase()}}List: LiveData<List<{{name.pascalCase()}}>> = _{{name.camelCase()}}List
    
    private val _selected{{name.pascalCase()}} = MutableLiveData<{{name.pascalCase()}}?>()
    val selected{{name.pascalCase()}}: LiveData<{{name.pascalCase()}}?> = _selected{{name.pascalCase()}}
    
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading
    
    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error
    
    fun load{{name.pascalCase()}}List() {
        _isLoading.value = true
        _error.value = null
        {{#hasRepository}}
        val result = repository.get{{name.pascalCase()}}List()
        result.observeForever { list ->
            _{{name.camelCase()}}List.value = list ?: emptyList()
            _isLoading.value = false
        }
        {{/hasRepository}}
        {{^hasRepository}}
        // TODO: Implement data loading
        _isLoading.value = false
        {{/hasRepository}}
    }
    
    fun load{{name.pascalCase()}}ById(id: String) {
        _isLoading.value = true
        _error.value = null
        {{#hasRepository}}
        val result = repository.get{{name.pascalCase()}}ById(id)
        result.observeForever { item ->
            _selected{{name.pascalCase()}}.value = item
            _isLoading.value = false
        }
        {{/hasRepository}}
        {{^hasRepository}}
        // TODO: Implement data loading
        _isLoading.value = false
        {{/hasRepository}}
    }
    {{/useLiveData}}
}
