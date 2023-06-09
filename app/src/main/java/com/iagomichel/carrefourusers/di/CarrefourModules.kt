package com.iagomichel.carrefourusers.di

import com.iagomichel.carrefourusers.BuildConfig
import com.iagomichel.carrefourusers.data.network.RetrofitConfig
import com.iagomichel.carrefourusers.data.repository.UserRepository
import com.iagomichel.carrefourusers.data.repository.UserRepositoryImpl
import com.iagomichel.carrefourusers.data.service.UsersApi
import com.iagomichel.carrefourusers.viewmodel.UsersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val carrefourModules = module {
    viewModel { UsersViewModel(get()) }
    single<UserRepository> { UserRepositoryImpl(get()) }

    single {
        RetrofitConfig.create(
            BuildConfig.BASE_API,
            UsersApi::class.java
        )
    }
}
