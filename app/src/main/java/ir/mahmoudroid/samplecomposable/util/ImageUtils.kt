package ir.mahmoudroid.samplecomposable.util

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.AmbientContext
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import ir.mahmoudroid.samplecomposable.R

const val DEFAULT_RECIPE_IMAGE = R.drawable.empty_plate

@Composable
fun loadPicture(
    url: String,
    @DrawableRes defaultImgae: Int
): MutableState<Bitmap?>{

    val bitmapState: MutableState<Bitmap?> = mutableStateOf(null)

    // load default image
    Glide.with(AmbientContext.current)
        .asBitmap()
        .load(defaultImgae).
            into(object: CustomTarget<Bitmap>(){
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                   bitmapState.value = resource
                }
                override fun onLoadCleared(placeholder: Drawable?) {}
            })

    // load url image
    Glide.with(AmbientContext.current)
        .asBitmap()
        .load(url).
        into(object: CustomTarget<Bitmap>(){
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmapState.value = resource
            }
            override fun onLoadCleared(placeholder: Drawable?) {}
        })


    return bitmapState
}