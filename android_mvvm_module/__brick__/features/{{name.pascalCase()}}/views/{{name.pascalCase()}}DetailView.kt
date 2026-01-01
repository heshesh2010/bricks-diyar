package com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.features.{{name.snakeCase()}}.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
{{#useFlow}}import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch{{/useFlow}}
import com.{{organization.snakeCase()}}.{{projectName.snakeCase()}}.features.{{name.snakeCase()}}.viewmodels.{{name.pascalCase()}}ViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Fragment to display details of a {{name.pascalCase()}}
 */
class {{name.pascalCase()}}DetailView : Fragment() {
    
    private val viewModel: {{name.pascalCase()}}ViewModel by viewModel()
    private var {{name.camelCase()}}Id: String? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            {{name.camelCase()}}Id = it.getString(ARG_{{name.constantCase()}}_ID)
        }
    }
    
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
        
        observeViewModel()
        {{name.camelCase()}}Id?.let {
            viewModel.load{{name.pascalCase()}}ById(it)
        }
    }
    
    private fun observeViewModel() {
        {{#useFlow}}
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.selected{{name.pascalCase()}}.collect { {{name.camelCase()}} ->
                {{name.camelCase()}}?.let {
                    // TODO: Update UI with {{name.camelCase()}} details
                }
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
        viewModel.selected{{name.pascalCase()}}.observe(viewLifecycleOwner) { {{name.camelCase()}} ->
            {{name.camelCase()}}?.let {
                // TODO: Update UI with {{name.camelCase()}} details
            }
        }
        
        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            // TODO: Show/hide loading indicator
        }
        
        viewModel.error.observe(viewLifecycleOwner) { error ->
            // TODO: Show error message
        }
        {{/useLiveData}}
    }
    
    companion object {
        private const val ARG_{{name.constantCase()}}_ID = "{{name.snakeCase()}}_id"
        
        @JvmStatic
        fun newInstance({{name.camelCase()}}Id: String) =
            {{name.pascalCase()}}DetailView().apply {
                arguments = Bundle().apply {
                    putString(ARG_{{name.constantCase()}}_ID, {{name.camelCase()}}Id)
                }
            }
    }
}
