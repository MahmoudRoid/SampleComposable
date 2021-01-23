package ir.mahmoudroid.samplecomposable.presentation.ui.recipe_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ir.mahmoudroid.samplecomposable.R
import ir.mahmoudroid.samplecomposable.util.TAG


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
                for(recipe in recipes){
                    Log.d(TAG, "RECIPE: ${recipe.title}")
                }


                Column(
                    modifier = Modifier
                        .border(border = BorderStroke(1.dp, Color.Black))
                        .padding(16.dp)
                ) {

                    Text(
                        text = "RecipeList",
                        style = TextStyle(
                            fontSize = TextUnit.Sp(21)
                        )
                    )
                    Spacer(modifier = Modifier.padding(10.dp))

                    Button(
                        onClick = {
                            //findNavController().navigate(R.id.action_recipeListFragment_to_recipeFragment)
                            viewModel.newSearch()
                        }
                    ) {
                        Text(text = "TO RECIPE FRAGMENT")
                    }

                }
            }
        }
    }

}