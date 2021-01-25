package ir.mahmoudroid.samplecomposable.presentation.ui.recipe_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.AndroidEntryPoint
import ir.mahmoudroid.samplecomposable.domain.model.Recipe
import ir.mahmoudroid.samplecomposable.repository.RecipeRepository
import kotlinx.coroutines.launch
import javax.inject.Named

class RecipeListViewModel @ViewModelInject constructor(
        private val repository: RecipeRepository,
         @Named("auth_token") private val token: String,
): ViewModel() {

    val recipes: MutableState<List<Recipe>> = mutableStateOf(ArrayList())

    init {
        newSearch()
    }

    fun newSearch(){
        viewModelScope.launch {
            val result = repository.search(
                    token = token,
                    page = 1,
                    query = "chicken"
            )
            recipes.value = result
        }
    }


}