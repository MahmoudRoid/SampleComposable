package ir.mahmoudroid.samplecomposable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import ir.mahmoudroid.samplecomposable.ui.theme.typography

class RecipeFragment:  Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply{
            setContent {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "This is Recipe Fragment",
                        style = TextStyle(
                            fontSize = TextUnit.Sp(21)
                        )
                    )
                }
            }
        }
    }
}