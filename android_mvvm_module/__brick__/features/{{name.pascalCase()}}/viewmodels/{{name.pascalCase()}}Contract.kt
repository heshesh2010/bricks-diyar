package com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.features.{{name.snakeCase()}}.viewmodels

/**
 * MVI Contract for {{name.pascalCase()}} feature
 * Defines State, Intent, and Effect for the feature
 */
sealed class {{name.pascalCase()}}Contract {

    /**
     * UI State
     */
    data class State(
        val isLoading: Boolean = false,
        val {{name.camelCase()}}List: List<com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.features.{{name.snakeCase()}}.models.{{name.pascalCase()}}> = emptyList(),
        val selected{{name.pascalCase()}}: com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.features.{{name.snakeCase()}}.models.{{name.pascalCase()}}? = null,
        val error: String? = null
    )

    /**
     * User Intents
     */
    sealed class Intent {
        object Load{{name.pascalCase()}}s : Intent()
        data class Select{{name.pascalCase()}}(val {{name.camelCase()}}Id: Int) : Intent()
        object ClearSelected{{name.pascalCase()}} : Intent()
        object Refresh : Intent()
        object ClearError : Intent()
    }

    /**
     * Side Effects (one-time events)
     */
    sealed class Effect {
        data class ShowToast(val message: String) : Effect()
        data class Navigate(val route: String) : Effect()
        object NavigateBack : Effect()
    }
}
