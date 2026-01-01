package com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.features.{{name.snakeCase()}}.models

import com.google.gson.annotations.SerializedName

/**
 * Data model for {{name.pascalCase()}}
 */
data class {{name.pascalCase()}}(
    @SerializedName("id")
    val id: String,
    
    @SerializedName("name")
    val name: String,
    
    @SerializedName("description")
    val description: String? = null,
    
    @SerializedName("created_at")
    val createdAt: String? = null
)
