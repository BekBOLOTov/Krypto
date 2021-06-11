package have.`fun`.with.krypto

import android.app.Application
import have.`fun`.with.krypto.di.dbModule
import have.`fun`.with.krypto.di.networkModule
import have.`fun`.with.krypto.di.repoModule
import have.`fun`.with.krypto.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KryptoApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@KryptoApp)
            modules(listOf(viewModelModule, repoModule, dbModule, networkModule))
        }
    }

}