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
            is {{name.pascalCase()}}Intent.Load{{name.pascalCase()}} -> load{{name.pascalCase()}}()
            is {{name.pascalCase()}}Intent.ClearError -> setState { copy(error = null) }
        }
    }

    private fun load{{name.pascalCase()}}() {
        safeCall(
            suspendCall = { {{name.camelCase()}}DataSource.fetch{{name.pascalCase()}}() },
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



   
}
