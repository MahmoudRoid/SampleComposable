package ir.mahmoudroid.samplecomposable.presentation.ui.recipe_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ir.mahmoudroid.samplecomposable.domain.model.Recipe
import ir.mahmoudroid.samplecomposable.presentation.components.RecipeCard


@AndroidEntryPoint
class RecipeListFragment: Fragment(){

    private val viewModel: RecipeListViewModel by viewModels()


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        return ComposeView(requireContext()).apply {
            setContent {

                // this will be changed when value changes in viewmodel ==> here it will be recomposed
                // because we are in a composable funtion
                val recipes = viewModel.recipes.value

                LazyColumn(content = {
                    itemsIndexed(
                        items = recipes
                    ) { index: Int, item: Recipe ->
                        RecipeCard(recipe = item, onClick = {})
                    }
                })

            }
        }
    }

}