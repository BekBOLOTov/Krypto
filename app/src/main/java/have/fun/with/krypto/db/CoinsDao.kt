package have.`fun`.with.krypto.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import have.`fun`.with.krypto.model.Coin

@Dao
interface CoinsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<Coin>)

    @Query("DELETE FROM coin")
    fun deleteAll()

    @Query("SELECT * FROM coin")
    fun getAll() : LiveData<List<Coin>>
}