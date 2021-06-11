package have.`fun`.with.krypto.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import have.`fun`.with.krypto.R
import have.`fun`.with.krypto.model.Coin
import have.`fun`.with.krypto.util.setImageByUrl

class CoinVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun onBind(coin: Coin) {
        itemView.apply {
            findViewById<TextView>(R.id.tv_name).text = coin.name
            findViewById<ImageView>(R.id.iv_logo).setImageByUrl(coin.icon)
            findViewById<TextView>(R.id.tv_price).text = resources.getString(R.string.dollar, coin.price)
        }

    }

    companion object {
        fun create(parent: ViewGroup) : CoinVH {
            return CoinVH(LayoutInflater.from(parent.context).inflate(R.layout.item_coin, parent, false))
        }
    }
}