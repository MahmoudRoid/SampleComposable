package ir.mahmoudroid.samplecomposable.presentation.ui.recipe_list

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import dagger.hilt.android.AndroidEntryPoint
import ir.mahmoudroid.samplecomposable.repository.RecipeRepository
import javax.inject.Named

@AndroidEntryPoint

class RecipeListViewModel @ViewModelInject constructor(
        private val repository: RecipeRepository,
         @Named("auth_token") private val token: String,
): ViewModel() {


    fun getRepo() = repository

    fun getAuthToken() = token

}