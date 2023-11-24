package pat.project.challengehack.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import impl.data.store.AuthorizationStore


@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun providersAuthStore(context: Context): AuthorizationStore = AuthorizationStore(context)

}