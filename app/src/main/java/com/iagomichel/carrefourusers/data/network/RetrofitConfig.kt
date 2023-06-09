package com.iagomichel.carrefourusers.data.network

import com.iagomichel.carrefourusers.data.service.UsersApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitConfig {

    private fun makeMoshiConverterFactory() =
        MoshiConverterFactory
            .create(MoshiBuilder.create())

    fun create(): UsersApi {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(makeMoshiConverterFactory())
            .build()

        val service: UsersApi = retrofit.create(UsersApi::class.java)

        return service
    }
}