package com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.features.{{name.snakeCase()}}.viewmodels

import com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.core.models.StringWrapper
import com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.features.{{name.snakeCase()}}.models.{{name.pascalCase()}}

data class {{name.pascalCase()}}UiState(
    val isLoading: Boolean = false,
    val {{name.camelCase()}}List: List<{{name.pascalCase()}}> = emptyList(),
    val selected{{name.pascalCase()}}: {{name.pascalCase()}}? = null,
    val error: StringWrapper? = null
)

sealed interface {{name.pascalCase()}}Intent {
    object Load{{name.pascalCase()}}s : {{name.pascalCase()}}Intent
    data class Select{{name.pascalCase()}}(val {{name.camelCase()}}Id: Int) : {{name.pascalCase()}}Intent
    object Refresh : {{name.pascalCase()}}Intent
    object ClearSelected : {{name.pascalCase()}}Intent
    object ClearError : {{name.pascalCase()}}Intent
}

sealed interface {{name.pascalCase()}}Effect {
    data class ShowToast(val message: StringWrapper) : {{name.pascalCase()}}Effect
    data class Navigate(val route: String) : {{name.pascalCase()}}Effect
    object NavigateBack : {{name.pascalCase()}}Effect
}
