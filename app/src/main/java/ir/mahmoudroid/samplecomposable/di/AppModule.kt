package ir.mahmoudroid.samplecomposable.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import ir.mahmoudroid.samplecomposable.presentation.BaseApplication
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext ctx: Context): BaseApplication {
        return ctx as BaseApplication
    }

    @Singleton
    @Provides
    fun provideRandomString(): String{
        return "Hey baby"
    }
}