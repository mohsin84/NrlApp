package mohsin.reza.propertyapp.di

import android.app.Application
import android.arch.persistence.room.Room
import com.android.example.github.util.LiveDataCallAdapterFactory
import dagger.Module
import dagger.Provides
import mohsin.reza.nrlapp.database.MatchDao
import mohsin.reza.nrlapp.database.NrlDb
import mohsin.reza.propertyapp.api.NrlServices
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
    fun provideNrlService(): NrlServices {
        return Retrofit.Builder()
                .baseUrl("http://demo0065087.mockable.io/test/")
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
