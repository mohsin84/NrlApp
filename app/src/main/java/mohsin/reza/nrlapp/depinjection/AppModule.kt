package mohsin.reza.nrlapp.depinjection

import dagger.Module
import dagger.Provides
import mohsin.reza.nrlapp.Util.LiveDataCallAdapterFactory
import mohsin.reza.nrlapp.network.NrlServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Dagger 2 Module for app. It provide Retrofit instance, Room Database instance and DataAccess Dao instance through out the app for injection
 */

@Module(includes = [ViewModelModule::class])
class AppModule {
    @Singleton
    @Provides
    fun provideNrlMatch(): NrlServices {
        return Retrofit.Builder()
                .baseUrl("https://statsapi.foxsports.com.au/3.0/api/sports/league/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .build()
                .create(NrlServices::class.java)
    }
}
