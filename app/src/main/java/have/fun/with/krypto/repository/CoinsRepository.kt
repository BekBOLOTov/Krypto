package have.`fun`.with.krypto.repository

import have.`fun`.with.krypto.db.CoinsDao
import have.`fun`.with.krypto.network.CoinsApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CoinsRepository(private val api: CoinsApi,
                      private val db: CoinsDao
                      ) {

    fun fetchCoinsFromServer() = api.fetchAllCoins()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                db.insertAll(it.coins)
                true
            }

    fun fetchCoinsFromDb() = db.getAll()
}