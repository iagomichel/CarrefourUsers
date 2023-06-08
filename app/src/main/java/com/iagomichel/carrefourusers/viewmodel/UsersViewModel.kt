package com.iagomichel.carrefourusers.viewmodel

import androidx.lifecycle.ViewModel
import com.iagomichel.carrefourusers.data.model.Users

class UsersViewModel: ViewModel() {

    fun fetchUsersList(): List<Users> {
        return listOf(
            Users(login = "abcde", id = 1),
            Users(login = "fghi", id = 2)
        )
    }
}
