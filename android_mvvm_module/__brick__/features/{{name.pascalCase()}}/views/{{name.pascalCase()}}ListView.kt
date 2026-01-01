package com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.features.{{name.snakeCase()}}.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
{{#useFlow}}import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch{{/useFlow}}
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.features.{{name.snakeCase()}}.viewmodels.{{name.pascalCase()}}ViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Fragment to display list of {{name.pascalCase()}}
 */
class {{name.pascalCase()}}ListView : Fragment() {
    
    private val viewModel: {{name.pascalCase()}}ViewModel by viewModel()
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // TODO: Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState)
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupRecyclerView()
        observeViewModel()
        viewModel.load{{name.pascalCase()}}List()
    }
    
    private fun setupRecyclerView() {
        // TODO: Setup RecyclerView
        // val recyclerView = view?.findViewById<RecyclerView>(R.id.recycler_view)
        // recyclerView?.layoutManager = LinearLayoutManager(context)
    }
    
    private fun observeViewModel() {
        {{#useFlow}}
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.{{name.camelCase()}}List.collect { list ->
                // TODO: Update adapter with list
            }
        }
        
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.isLoading.collect { isLoading ->
                // TODO: Show/hide loading indicator
            }
        }
        
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.error.collect { error ->
                // TODO: Show error message
            }
        }
        {{/useFlow}}
        {{#useLiveData}}
        viewModel.{{name.camelCase()}}List.observe(viewLifecycleOwner) { list ->
            // TODO: Update adapter with list
        }
        
        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            // TODO: Show/hide loading indicator
        }
        
        viewModel.error.observe(viewLifecycleOwner) { error ->
            // TODO: Show error message
        }
        {{/useLiveData}}
    }
}
