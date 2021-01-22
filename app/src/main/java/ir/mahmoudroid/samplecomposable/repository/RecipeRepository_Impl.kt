package ir.mahmoudroid.samplecomposable.repository

import ir.mahmoudroid.samplecomposable.domain.model.Recipe
import ir.mahmoudroid.samplecomposable.network.RecipeService
import ir.mahmoudroid.samplecomposable.network.model.RecipeDtoMapper

class RecipeRepository_Impl (
        private val recipeService: RecipeService,
        private val mapper: RecipeDtoMapper,
): RecipeRepository {

    override suspend fun search(token: String, page: Int, query: String): List<Recipe> {
        return mapper.toDomainList(recipeService.search(token = token, page = page, query = query).recipes)
    }

    override suspend fun get(token: String, id: Int): Recipe {
        return mapper.mapToDomainModel(recipeService.get(token = token, id))
    }

}