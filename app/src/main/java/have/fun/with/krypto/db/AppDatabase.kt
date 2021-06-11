package have.`fun`.with.krypto.db

import androidx.room.Database
import androidx.room.RoomDatabase
import have.`fun`.with.krypto.model.Coin

@Database(entities = [Coin::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract val coinsDao : CoinsDao
}