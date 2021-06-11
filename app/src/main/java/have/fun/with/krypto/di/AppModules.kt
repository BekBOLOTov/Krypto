package have.`fun`.with.krypto.di

import android.app.Application
import androidx.room.Room
import have.`fun`.with.krypto.BuildConfig
import have.`fun`.with.krypto.BuildConfig.BASE_URL
import have.`fun`.with.krypto.db.AppDatabase
import have.`fun`.with.krypto.network.CoinsApi
import have.`fun`.with.krypto.repository.CoinsRepository
import have.`fun`.with.krypto.ui.main.MainVM
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModule = module {
    viewModel { MainVM(get()) }
}
val repoModule = module {
    single { CoinsRepository(get(), get()) }
}
val dbModule = module {

    fun provideAppDb(application: Application) =
        Room.databaseBuilder(application, AppDatabase::class.java, "krypto_db")
            .allowMainThreadQueries()
            .build()

    fun provideCoinsDao(db : AppDatabase) = db.coinsDao

    single { provideAppDb(get()) }
    single { provideCoinsDao(get()) }
}
val networkModule = module {
    single {
        val clientBuilder = OkHttpClient.Builder()
        val loggingInterceptor = HttpLoggingInterceptor()
        if(BuildConfig.DEBUG)
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        clientBuilder.addInterceptor(loggingInterceptor)
        clientBuilder.build()
    }
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(CoinsApi::class.java)
    }
}