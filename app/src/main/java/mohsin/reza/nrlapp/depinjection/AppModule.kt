package mohsin.reza.propertyapp.di

import android.app.Application
import android.arch.persistence.room.Room
import dagger.Module
import dagger.Provides
import mohsin.reza.nrlapp.Util.LiveDataCallAdapterFactory
import mohsin.reza.nrlapp.database.MatchDao
import mohsin.reza.nrlapp.database.NrlDb
import mohsin.reza.nrlapp.depinjection.ViewModelModule
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
                .baseUrl("https://statsapi.foxsports.com.au/3.0/api/sports/league/matches/NRL20172101/topplayerstats.json;type=fantasy_points;type=tackles;type=runs;type=run_metres?limit=5&userkey=A00239D3-45F6-4A0A-810C-54A347F144C2")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .build()
                .create(NrlServices::class.java) //TODO: Check the extension
    }

    @Singleton
    @Provides
    fun providesDB(application: Application): NrlDb {
        return Room.databaseBuilder(application, NrlDb::class.java, "propertyDb.db")
                .fallbackToDestructiveMigration()
                .build()
    }

    @Singleton
    @Provides
    fun provideMatchDao(db: NrlDb): MatchDao {
        return db.propertyDao()
    }
}
