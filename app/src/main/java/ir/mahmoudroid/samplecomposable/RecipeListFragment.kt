package ir.mahmoudroid.samplecomposable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContract
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class RecipeListFragment: Fragment(){

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        return ComposeView(requireContext()).apply {
            setContent {
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
                            findNavController().navigate(R.id.action_recipeListFragment_to_recipeFragment)
                        }
                    ) {
                        Text(text = "TO RECIPE FRAGMENT")
                    }

                }
            }
        }
    }

}