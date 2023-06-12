package com.iagomichel.carrefourusers.data.network

import com.iagomichel.carrefourusers.data.service.UsersApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitConfig {

    private fun makeMoshiConverterFactory() =
        MoshiConverterFactory
            .create(MoshiBuilder.create())

    fun <T> create(
        baseURL: String,
        serviceInterface: Class<T>
    ): T {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(makeMoshiConverterFactory())
            .build()

        return retrofit.create(serviceInterface)
    }
}
