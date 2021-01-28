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
import ir.mahmoudroid.samplecomposable.presentation.components.FoodCategoryChip
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

                val query = viewModel.query.value  // first way


                Column {
                    // Toolbar not used because of fixed height ==> but surface can has flexible size
                    Surface(
                            modifier = Modifier
                                    .fillMaxWidth()
                            ,
                            color = Color.White,
                            elevation = 8.dp,
                    ){

                        Column {
                            Row(modifier = Modifier.fillMaxWidth()){
                                TextField(
                                        modifier = Modifier
                                                .fillMaxWidth(.9f)
                                                .padding(8.dp)
                                        ,
                                        value = query,
                                        onValueChange = {
                                            viewModel.onQueryChanged(it)
                                        },
                                        label = {
                                            Text(text = "Search")
                                        },
                                        keyboardOptions = KeyboardOptions(
                                                keyboardType = KeyboardType.Text,
                                                imeAction = ImeAction.Done,
                                        ),
                                        leadingIcon = {
                                            Icon(Icons.Filled.Search)
                                        },
                                        onImeActionPerformed = { action, softKeyboardController ->
                                            if (action == ImeAction.Done) {
                                                viewModel.newSearch(query)
                                                softKeyboardController?.hideSoftwareKeyboard()
                                            }
                                        },
                                        textStyle = TextStyle(color = MaterialTheme.colors.onSurface),
                                        backgroundColor = MaterialTheme.colors.surface
                                )
                            }
                            // Scrollable Row
                            ScrollableRow(modifier = Modifier.fillMaxWidth()){
                                for(category in getAllFoodCategories()){
                                    FoodCategoryChip(
                                            category = category.value,
                                            onExecuteSearch = {
                                                viewModel.apply {
                                                    onQueryChanged(it)
                                                    newSearch(it)
                                                }
                                            }
                                    )
                                }
                            }
                        }
                    }

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

}