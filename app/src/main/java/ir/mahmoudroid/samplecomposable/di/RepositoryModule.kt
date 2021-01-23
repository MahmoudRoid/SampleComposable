package ir.mahmoudroid.samplecomposable.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import ir.mahmoudroid.samplecomposable.network.RecipeService
import ir.mahmoudroid.samplecomposable.network.model.RecipeDtoMapper
import ir.mahmoudroid.samplecomposable.repository.RecipeRepository
import ir.mahmoudroid.samplecomposable.repository.RecipeRepository_Impl
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {


    @Singleton
    @Provides
    fun provideRecipeRepository(
           recipeService: RecipeService,
           mapper: RecipeDtoMapper
    ): RecipeRepository{
        return RecipeRepository_Impl(recipeService,mapper)
    }


}