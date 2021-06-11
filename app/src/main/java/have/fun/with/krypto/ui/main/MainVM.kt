package have.`fun`.with.krypto.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import have.`fun`.with.krypto.model.Coin
import have.`fun`.with.krypto.repository.CoinsRepository

class MainVM(private val repo: CoinsRepository) : ViewModel() {

    var coins = listOf<Coin>()
    var errors = MutableLiveData<String>()

    fun fetchAllCoinsFromServer() {
        repo.fetchCoinsFromServer().subscribe({}, {
            handleErrors(it)
        })
    }

    fun fetchAllCoinsFromDb() = repo.fetchCoinsFromDb()

    fun handleErrors(throwable: Throwable) {
        errors.postValue(throwable.message)
    }
}