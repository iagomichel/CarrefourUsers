package com.iagomichel.carrefourusers.data.repository

import com.iagomichel.carrefourusers.data.model.Users

interface UserRepository {

    suspend fun fetchRemoteDataUsers(): List<Users>
}
