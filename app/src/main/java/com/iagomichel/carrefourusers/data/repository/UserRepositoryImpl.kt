package com.iagomichel.carrefourusers.data.repository

import com.iagomichel.carrefourusers.data.model.Users
import com.iagomichel.carrefourusers.data.network.RetrofitConfig

class UserRepositoryImpl: UserRepository {

    override suspend fun fetchRemoteDataUsers(): List<Users> {
        return RetrofitConfig.create().fetchUsers()
    }
}
