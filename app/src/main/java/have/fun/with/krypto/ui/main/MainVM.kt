package have.`fun`.with.krypto.ui.main

import android.content.res.Resources
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import have.`fun`.with.krypto.R
import have.`fun`.with.krypto.model.Coin
import have.`fun`.with.krypto.network.NoConnectivityException
import have.`fun`.with.krypto.repository.CoinsRepository
import retrofit2.HttpException
import javax.net.ssl.HttpsURLConnection

class MainVM(private val repo: CoinsRepository, private val resources: Resources) : ViewModel() {

    var coins = listOf<Coin>()
    var errors = MutableLiveData<String>()

    fun fetchAllCoinsFromServer() {
        repo.fetchCoinsFromServer().subscribe({}, {
            handleErrors(it)
        })
    }

    fun fetchAllCoinsFromDb() = repo.fetchCoinsFromDb()

    fun handleErrors(throwable: Throwable) {

        if(throwable is HttpException) {
            errors.value = resources.getString(when(throwable.code()) {
                HttpsURLConnection.HTTP_INTERNAL_ERROR -> R.string.server_error
                else -> R.string.unknown_error
            })
        }
        else if(throwable is NoConnectivityException) {
            errors.value = resources.getString(R.string.no_connection)
        }
        else {
            errors.value = resources.getString(R.string.unknown_error)
        }
    }
}