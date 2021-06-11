package have.`fun`.with.krypto.repository

import com.google.gson.Gson
import have.`fun`.with.krypto.network.CoinsApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CoinsRepository(private val api: CoinsApi) {

    fun fetchCoinsFromServer() = api.fetchAllCoins()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                it.coins
            }
}