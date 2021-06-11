package have.`fun`.with.krypto.ui.main.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import have.`fun`.with.krypto.model.Coin

class CoinsAdapter : RecyclerView.Adapter<CoinVH>() {

    private val items = mutableListOf<Coin>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinVH {
        return CoinVH.create(parent)
    }

    override fun onBindViewHolder(holder: CoinVH, position: Int) {
        holder.onBind(items[position])
    }

    override fun getItemCount() = items.size

    fun addItems(list: List<Coin>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }
}