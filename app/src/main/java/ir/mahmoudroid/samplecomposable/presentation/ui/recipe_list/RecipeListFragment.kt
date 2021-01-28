package ir.mahmoudroid.samplecomposable.presentation.ui.recipe_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Space
import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.savedinstancestate.savedInstanceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ir.mahmoudroid.samplecomposable.domain.model.Recipe
import ir.mahmoudroid.samplecomposable.presentation.components.CircularIndeterminateProgressBar
import ir.mahmoudroid.samplecomposable.presentation.components.FoodCategoryChip
import ir.mahmoudroid.samplecomposable.presentation.components.RecipeCard
import ir.mahmoudroid.samplecomposable.presentation.components.SearchAppBar


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

                val recipes = viewModel.recipes.value

                val query = viewModel.query.value

                val selectedCategory = viewModel.selectedCategory.value

                val categoryScrollPosition = viewModel.categoryScrollPosition

                val loading = viewModel.loading.value

                Column {

                    SearchAppBar(
                            query = query,
                            onQueryChanged = viewModel::onQueryChanged,
                            onExecuteSearch = viewModel::newSearch,
                            categories = getAllFoodCategories(),
                            selectedCategory = selectedCategory,
                            onSelectedCategoryChanged = viewModel::onSelectedCategoryChanged,
                            scrollPosition = categoryScrollPosition,
                            onChangeScrollPosition = viewModel::onChangeCategoryScrollPosition,
                    )

                    // box means ==> every children lays over each other
                    // it has Priority from TOP to DOWN
                    // persian ==> children roo ham mioftan
                    // dar in halat progressbar miofte roo recycler

                    Box(modifier = Modifier.fillMaxSize()) {

                        LazyColumn {
                            itemsIndexed(
                                    items = recipes
                            ) { index, recipe ->
                                RecipeCard(recipe = recipe, onClick = {})
                            }
                        }

                        CircularIndeterminateProgressBar(isDisplayed = loading)

                    }
                }
            }
        }
    }

}