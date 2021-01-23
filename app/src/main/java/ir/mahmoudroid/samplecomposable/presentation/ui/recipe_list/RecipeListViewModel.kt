package ir.mahmoudroid.samplecomposable.presentation.ui.recipe_list

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class RecipeListViewModel @ViewModelInject constructor(
        private val randomString: String
): ViewModel() {

    init {
        println("VIEWMODEL: $randomString")
    }

}