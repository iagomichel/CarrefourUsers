package com.iagomichel.carrefourusers.data.repository

import com.iagomichel.carrefourusers.data.model.Users
import com.iagomichel.carrefourusers.data.service.UsersApi


class UserRepositoryImpl(
    private val usersApi: UsersApi
): UserRepository {

    override suspend fun fetchRemoteDataUsers(): List<Users> {
        return usersApi.fetchUsers()
    }
}
