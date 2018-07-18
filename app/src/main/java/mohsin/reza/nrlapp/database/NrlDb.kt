package mohsin.reza.nrlapp.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import mohsin.reza.nrlapp.model.Match

/*
* Room database entities and dao objects
* */

//@Database(
//        entities = [Match::class],
//        version = 1,
//        exportSchema = false
//)
abstract class NrlDb : RoomDatabase() {

    abstract fun propertyDao(): MatchDao
}
