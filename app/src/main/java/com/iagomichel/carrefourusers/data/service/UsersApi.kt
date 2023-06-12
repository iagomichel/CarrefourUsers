package com.iagomichel.carrefourusers.data.service

import com.iagomichel.carrefourusers.data.model.Users
import retrofit2.http.GET

interface UsersApi {
    @GET("users")
    suspend fun fetchUsers(): List<Users>
}
