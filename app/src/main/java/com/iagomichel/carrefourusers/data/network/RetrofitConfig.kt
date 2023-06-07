package com.iagomichel.carrefourusers.data.network

import com.iagomichel.carrefourusers.data.service.UsersApi
import retrofit2.Retrofit

object RetrofitConfig {
    fun create(): UsersApi {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .build()

        val service: UsersApi = retrofit.create(UsersApi::class.java)

        return service
    }
}