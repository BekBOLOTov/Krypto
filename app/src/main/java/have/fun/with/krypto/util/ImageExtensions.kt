package have.`fun`.with.krypto.util

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.setImageByUrl(url: String) {
    Glide.with(this).load(url).into(this)
}