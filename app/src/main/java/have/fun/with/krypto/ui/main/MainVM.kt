package have.`fun`.with.krypto.ui.main

import androidx.lifecycle.ViewModel
import have.`fun`.with.krypto.repository.CoinsRepository

class MainVM(private val repo: CoinsRepository) : ViewModel() {

    fun fetchAllCoinsFromServer() {
        repo.fetchCoinsFromServer().subscribe {

        }
    }
}