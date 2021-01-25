package ir.mahmoudroid.samplecomposable.presentation.ui.recipe_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.savedinstancestate.savedInstanceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
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
                // below code seems to be like var query=beef;   in fragments...
                //val query = remember { mutableStateOf("beef") } // with this item ==> data will be lost during screen rotation ==> so use below way
                val query = viewModel.query.value  // first way

                val _query = savedInstanceState{"beef"}



                Column {


                    TextField(
                        value = query,   // or _query.value
                        onValueChange = { newValue ->
                            // first way
                        viewModel.onQueryChanged(newValue)
                            //second way with savedInstanceState
                           // _query.value = newValue
                    })

                    Spacer(modifier = Modifier.padding(10.dp))

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