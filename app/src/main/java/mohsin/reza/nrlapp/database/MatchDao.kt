package mohsin.reza.nrlapp.database

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import mohsin.reza.nrlapp.model.Match

@Dao
abstract class MatchDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insert(propertyList: List<Match>)


    @Query("Select * from Property")
    abstract fun loadPropertyList(): LiveData<List<Match>>
}
