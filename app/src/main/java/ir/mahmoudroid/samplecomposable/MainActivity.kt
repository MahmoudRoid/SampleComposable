package ir.mahmoudroid.samplecomposable

import android.content.res.Resources
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.graphics.imageFromResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            ScrollableColumn(
                    modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .background(Color(0xFF7A819C))
            ) {
                Image(
                        bitmap = imageFromResource(
                                res = resources,
                                resId = R.drawable.happy_meal),
                        modifier = Modifier.height(300.dp),
                        contentScale = ContentScale.Crop
                )

                Column(
                        modifier = Modifier.padding(10.dp)
                ) {

                    Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                                text = "Happy Meal",
                                style = TextStyle(
                                        fontSize = TextUnit.Companion.Sp(26)
                                )
                        )
                        Text(
                                text = "29$",
                                style = TextStyle(
                                        fontSize = TextUnit.Companion.Sp(14)
                                ),
                                modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }
                    Spacer(modifier = Modifier.padding(10.dp))
                    Text(
                            text = "800 calories",
                            style = TextStyle(
                                    fontSize = TextUnit.Companion.Sp(20)
                            )
                    )
                    Spacer(modifier = Modifier.padding(10.dp))

                    Button(
                            onClick = {},
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        Text(text = "order Now")
                    }



                }

            }
        }
    }
}
