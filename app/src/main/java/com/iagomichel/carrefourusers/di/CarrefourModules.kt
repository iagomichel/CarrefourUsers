package com.iagomichel.carrefourusers.di

import com.iagomichel.carrefourusers.viewmodel.UsersViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val carrefourModules = module {
    singleOf(::UsersViewModel)
}
