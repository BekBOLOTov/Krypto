package have.`fun`.with.krypto.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Coin(
    @PrimaryKey
    val id: String, val name: String)

data class ResponseWrapper(val coins: List<Coin>)