package have.`fun`.with.krypto

import android.app.Application
import have.`fun`.with.krypto.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KryptoApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@KryptoApp)
            modules(listOf(appModule, viewModelModule, repoModule, dbModule, networkModule))
        }
    }

}