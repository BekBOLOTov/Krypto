package have.`fun`.with.krypto.di

import have.`fun`.with.krypto.repository.CoinsRepository
import have.`fun`.with.krypto.ui.main.MainVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainVM() }
}
val repoModule = module {
    single { CoinsRepository() }
}
val dbModule = module {

}
val networkModule = module {

}