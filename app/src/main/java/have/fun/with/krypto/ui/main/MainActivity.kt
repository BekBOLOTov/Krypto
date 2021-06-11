package have.`fun`.with.krypto.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import have.`fun`.with.krypto.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    val mainVM by viewModel<MainVM>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainVM.fetchAllCoinsFromServer()
        subscribeToLiveData()
    }

    private fun subscribeToLiveData() {
        mainVM.fetchAllCoinsFromDb().observe(this, {
        })

        mainVM.errors.observe(this, {
            Toast.makeText(this, it, LENGTH_SHORT).show()
        })

    }
}