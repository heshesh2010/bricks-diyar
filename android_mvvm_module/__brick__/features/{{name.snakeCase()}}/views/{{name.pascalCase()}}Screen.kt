package com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.features.{{name.snakeCase()}}.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.features.{{name.snakeCase()}}.models.{{name.pascalCase()}}
import com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.features.{{name.snakeCase()}}.viewmodels.{{name.pascalCase()}}Contract
import com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.features.{{name.snakeCase()}}.viewmodels.{{name.pascalCase()}}ViewModel
import kotlinx.coroutines.flow.collectLatest

/**
 * Main screen for {{name.pascalCase()}} feature
 * Implements MVI pattern with state management
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun {{name.pascalCase()}}Screen(
    on{{name.pascalCase()}}Click: ((Int) -> Unit)? = null,
    onBackClick: (() -> Unit)? = null,
    viewModel: {{name.pascalCase()}}ViewModel = viewModel()
) {
    val state by viewModel.state.collectAsState()

    // Handle side effects
    LaunchedEffect(Unit) {
        viewModel.effect.collectLatest { effect ->
            when (effect) {
                is {{name.pascalCase()}}Contract.Effect.ShowToast -> {
                    // Show toast message
                }
                is {{name.pascalCase()}}Contract.Effect.Navigate -> {
                    // Handle navigation
                }
                is {{name.pascalCase()}}Contract.Effect.NavigateBack -> {
                    onBackClick?.invoke()
                }
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { 
                    Text(
                        text = if (state.selected{{name.pascalCase()}} != null) "{{name.pascalCase()}} Details" else "{{name.pascalCase()}}s",
                        fontWeight = FontWeight.Bold
                    ) 
                },
                navigationIcon = {
                    if (state.selected{{name.pascalCase()}} != null) {
                        IconButton(onClick = { 
                            viewModel.handleIntent({{name.pascalCase()}}Contract.Intent.ClearSelected{{name.pascalCase()}})
                        }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    }
                },
                actions = {
                    if (state.selected{{name.pascalCase()}} == null) {
                        IconButton(onClick = { 
                            viewModel.handleIntent({{name.pascalCase()}}Contract.Intent.Refresh)
                        }) {
                            Icon(
                                imageVector = Icons.Default.Refresh,
                                contentDescription = "Refresh"
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when {
                state.isLoading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                state.error != null -> {
                    Column(
                        modifier = Modifier.align(Alignment.Center),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = state.error ?: "An error occurred",
                            color = MaterialTheme.colorScheme.error,
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = { 
                                viewModel.handleIntent({{name.pascalCase()}}Contract.Intent.Refresh)
                            }
                        ) {
                            Text("Retry")
                        }
                    }
                }
                state.selected{{name.pascalCase()}} != null -> {
                    {{name.pascalCase()}}DetailContent(
                        {{name.camelCase()}} = state.selected{{name.pascalCase()}}!!
                    )
                }
                else -> {
                    {{name.pascalCase()}}ListContent(
                        {{name.camelCase()}}s = state.{{name.camelCase()}}List,
                        on{{name.pascalCase()}}Click = { {{name.camelCase()}}Id ->
                            on{{name.pascalCase()}}Click?.invoke({{name.camelCase()}}Id)
                                ?: viewModel.handleIntent({{name.pascalCase()}}Contract.Intent.Select{{name.pascalCase()}}({{name.camelCase()}}Id))
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun {{name.pascalCase()}}ListContent(
    {{name.camelCase()}}s: List<{{name.pascalCase()}}>,
    on{{name.pascalCase()}}Click: (Int) -> Unit
) {
    if ({{name.camelCase()}}s.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "No {{name.camelCase()}}s available",
                style = MaterialTheme.typography.bodyLarge
            )
        }
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

@Composable
private fun {{name.pascalCase()}}ListItem(
    {{name.camelCase()}}: {{name.pascalCase()}},
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = {{name.camelCase()}}.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = {{name.camelCase()}}.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
private fun {{name.pascalCase()}}DetailContent(
    {{name.camelCase()}}: {{name.pascalCase()}}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .align(Alignment.CenterHorizontally),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        modifier = Modifier.size(60.dp),
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
                
                Spacer(modifier = Modifier.height(24.dp))
                
                Text(
                    text = {{name.camelCase()}}.name,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Text(
                    text = "ID: ${{{name.camelCase()}}.id}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                
                Spacer(modifier = Modifier.height(24.dp))
                
                Divider()
                
                Spacer(modifier = Modifier.height(24.dp))
                
                Text(
                    text = "Description",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Text(
                    text = {{name.camelCase()}}.description,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
