package have.`fun`.with.krypto.ui.main.adapter

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import have.`fun`.with.krypto.model.Coin

class CoinsAdapter : RecyclerView.Adapter<CoinVH>() {

    private val items = mutableListOf<Coin>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinVH {
        Log.d("Bolot", "create")
        return CoinVH.create(parent)
    }

    override fun onBindViewHolder(holder: CoinVH, position: Int) {
        Log.d("Bolot", "bind")
        holder.onBind(items[position])
    }

    override fun getItemCount() : Int {
        Log.d("Bolot", "get item count")
        return items.size
    }

    fun addItems(list: List<Coin>) {
        Log.d("Bolot", "items -> " + items.size)
        items.clear()
        items.addAll(list)
        Log.d("Bolot", "items -> " + items.size)
        notifyDataSetChanged()
    }
}