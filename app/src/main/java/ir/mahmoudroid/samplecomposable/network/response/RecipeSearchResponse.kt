package ir.mahmoudroid.samplecomposable.network.response

import com.google.gson.annotations.SerializedName
import ir.mahmoudroid.samplecomposable.network.model.RecipeNetworkEntity

class RecipeSearchResponse(

        @SerializedName("count")
        var count: Int,

        @SerializedName("results")
        var recipes: List<RecipeNetworkEntity>,
)