package have.`fun`.with.krypto.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import have.`fun`.with.krypto.R
import have.`fun`.with.krypto.ui.main.adapter.CoinsAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val mainVM by viewModel<MainVM>()
    private var coinsAdapter: CoinsAdapter?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupView()
        mainVM.fetchAllCoinsFromServer()
        subscribeToLiveData()
    }

    private fun setupView() {
        findViewById<RecyclerView>(R.id.recycler_view).apply {
            coinsAdapter = CoinsAdapter()
            layoutManager = LinearLayoutManager(this@MainActivity)
            itemAnimator = DefaultItemAnimator()
            adapter = coinsAdapter
        }

        findViewById<EditText>(R.id.et_search).addTextChangedListener { editable ->
            coinsAdapter?.addItems(
                mainVM.coins.filter { it.name.contains(editable.toString(), true) }
            )
        }
    }

    private fun subscribeToLiveData() {
        mainVM.fetchAllCoinsFromDb().observe(this, {
            mainVM.coins = it
            coinsAdapter?.addItems(it)
        })

        mainVM.errors.observe(this, {
            Toast.makeText(this, it, LENGTH_SHORT).show()
        })

    }
}