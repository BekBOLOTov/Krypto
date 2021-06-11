package have.`fun`.with.krypto.network

import have.`fun`.with.krypto.model.ResponseWrapper
import io.reactivex.Observable
import retrofit2.http.GET

interface CoinsApi {
    @GET("coins")
    fun fetchAllCoins(): Observable<ResponseWrapper>
}