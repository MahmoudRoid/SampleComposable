package ir.mahmoudroid.samplecomposable.network.response

import com.google.gson.annotations.SerializedName
import ir.mahmoudroid.samplecomposable.network.model.RecipeDto

data class RecipeSearchResponse(

        @SerializedName("count")
        var count: Int,

        @SerializedName("results")
        var recipes: List<RecipeDto>,
)