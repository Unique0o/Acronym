package com.manager.app.di

import com.manager.app.data.network.api.ApiService
import com.manager.app.data.preferences.PreferenceProvider
import com.facebook.shimmer.Shimmer
import com.manager.app.MyApplication
import com.manager.app.data.network.client.RemoteDataSource
import com.manager.app.data.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRemoteDataSource(): RemoteDataSource {
        return RemoteDataSource()
    }

    @Singleton
    @Provides
    fun provideAcronymApi(
        remoteDataSource: RemoteDataSource
    ): ApiService {
        return remoteDataSource.buildApi(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideAuthRepository(
        apiService: ApiService,
    ): AuthRepository {
        return AuthRepository(apiService)
    }

    @Singleton
    @Provides
    fun provideSharedPreference(): PreferenceProvider {
        return PreferenceProvider.getInstance(MyApplication.getApp()!!.applicationContext)
    }

    @Singleton
    @Provides
    fun provideShimmerBuilder(): Shimmer {
        return Shimmer.AlphaHighlightBuilder()// The attributes for a ShimmerDrawable is set by this builder
                .setDuration(1000) // how long the shimmering animation takes to do one full sweep
                .setBaseAlpha(0.5f) //the alpha of the underlying children
                .setHighlightAlpha(0.6f) // the shimmer alpha amount
                .setDirection(Shimmer.Direction.LEFT_TO_RIGHT).setAutoStart(true).build()

    }

}
