package com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.features.{{name.snakeCase()}}.viewmodels

import com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.R
import com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.core.bases.BaseViewModel
import com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.core.models.StringWrapper
import com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.features.{{name.snakeCase()}}.datasources.{{name.pascalCase()}}DataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * ViewModel for {{name.pascalCase()}} feature using BaseViewModel MVI base
 */
@HiltViewModel
class {{name.pascalCase()}}ViewModel @Inject constructor(
    private val {{name.camelCase()}}DataSource: {{name.pascalCase()}}DataSource
) : BaseViewModel<{{name.pascalCase()}}UiState, {{name.pascalCase()}}Intent, {{name.pascalCase()}}Effect>() {

    override fun createInitialState(): {{name.pascalCase()}}UiState = {{name.pascalCase()}}UiState()

    override fun handleIntent(intent: {{name.pascalCase()}}Intent) {
        when (intent) {
            is {{name.pascalCase()}}Intent.Load{{name.pascalCase()}}s -> load{{name.pascalCase()}}s()
            is {{name.pascalCase()}}Intent.Select{{name.pascalCase()}} -> load{{name.pascalCase()}}Details(intent.{{name.camelCase()}}Id)
            is {{name.pascalCase()}}Intent.Refresh -> refresh{{name.pascalCase()}}s()
            is {{name.pascalCase()}}Intent.ClearSelected -> setState { copy(selected{{name.pascalCase()}} = null) }
            is {{name.pascalCase()}}Intent.ClearError -> setState { copy(error = null) }
        }
    }

    private fun load{{name.pascalCase()}}s() {
        safeCall(
            suspendCall = { {{name.camelCase()}}DataSource.fetch{{name.pascalCase()}}s() },
            onLoading = { setState { copy(isLoading = true) } },
            onSuccess = { result ->
                setState { copy(isLoading = false, {{name.camelCase()}}List = result ?: emptyList(), error = null) }
            },
            onError = { message ->
                setState { copy(isLoading = false) }
                sendEffect({{name.pascalCase()}}Effect.ShowToast(message ?: StringWrapper.StringResource(R.string.error_occurred)))
            }
        )
    }

    private fun load{{name.pascalCase()}}Details({{name.camelCase()}}Id: Int) {
        safeCall(
            suspendCall = { {{name.camelCase()}}DataSource.fetch{{name.pascalCase()}}ById({{name.camelCase()}}Id) },
            onLoading = { setState { copy(isLoading = true) } },
            onSuccess = { result ->
                setState { copy(isLoading = false, selected{{name.pascalCase()}} = result, error = null) }
            },
            onError = { message ->
                setState { copy(isLoading = false) }
                sendEffect({{name.pascalCase()}}Effect.ShowToast(message ?: StringWrapper.StringResource(R.string.error_occurred)))
            }
        )
    }

    private fun refresh{{name.pascalCase()}}s() {
        load{{name.pascalCase()}}s()
    }
}
