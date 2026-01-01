package com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.features.{{name.snakeCase()}}.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.core.helpers.Resource
import com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.features.{{name.snakeCase()}}.models.{{name.pascalCase()}}
import com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.features.{{name.snakeCase()}}.viewmodels.{{name.pascalCase()}}ViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun {{name.pascalCase()}}ListView(
    on{{name.pascalCase()}}Click: (Int) -> Unit,
    viewModel: {{name.pascalCase()}}ViewModel = viewModel()
) {
    val {{name.camelCase()}}sState by viewModel.{{name.camelCase()}}sState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("{{name.pascalCase()}}s", fontWeight = FontWeight.Bold) },
                actions = {
                    IconButton(onClick = { viewModel.get{{name.pascalCase()}}s() }) {
                        Icon(
                            imageVector = Icons.Default.Refresh,
                            contentDescription = "Refresh"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when ({{name.camelCase()}}sState) {
                is Resource.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                is Resource.Success -> {
                    val {{name.camelCase()}}s = {{name.camelCase()}}sState.data ?: emptyList()
                    if ({{name.camelCase()}}s.isEmpty()) {
                        Text(
                            text = "No {{name.camelCase()}}s available",
                            modifier = Modifier.align(Alignment.Center),
                            style = MaterialTheme.typography.bodyLarge
                        )
                    } else {
                        LazyColumn(
                            modifier = Modifier.fillMaxSize(),
                            contentPadding = PaddingValues(16.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            items({{name.camelCase()}}s) { {{name.camelCase()}} ->
                                {{name.pascalCase()}}ListItem(
                                    {{name.camelCase()}} = {{name.camelCase()}},
                                    onClick = { on{{name.pascalCase()}}Click({{name.camelCase()}}.id) }
                                )
                            }
                        }
                    }
                }
                is Resource.Error -> {
                    Column(
                        modifier = Modifier.align(Alignment.Center),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = {{name.camelCase()}}sState.message ?: "An error occurred",
                            color = MaterialTheme.colorScheme.error,
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(onClick = { viewModel.get{{name.pascalCase()}}s() }) {
                            Text("Retry")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun {{name.pascalCase()}}ListItem(
    {{name.camelCase()}}: {{name.pascalCase()}},
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Avatar
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "{{name.pascalCase()}} Avatar",
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(32.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            // {{name.pascalCase()}} Info
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = {{name.camelCase()}}.name.ifEmpty { "Unknown {{name.pascalCase()}}" },
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = {{name.camelCase()}}.description.ifEmpty { "No description" },
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}
