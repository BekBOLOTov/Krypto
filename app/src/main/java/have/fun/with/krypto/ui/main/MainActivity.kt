package have.`fun`.with.krypto.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import have.`fun`.with.krypto.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    val mainVM by viewModel<MainVM>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainVM.fetchAllCoinsFromServer()
    }
}