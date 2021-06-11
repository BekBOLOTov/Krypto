package have.`fun`.with.krypto.model

data class Coin(val id: String)

data class ResponseWrapper(val coins: List<Coin>)