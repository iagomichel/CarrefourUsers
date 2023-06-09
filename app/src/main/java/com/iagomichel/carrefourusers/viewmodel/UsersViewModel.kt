package com.iagomichel.carrefourusers.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iagomichel.carrefourusers.data.model.Users
import com.iagomichel.carrefourusers.data.repository.UserRepository
import kotlinx.coroutines.launch

class UsersViewModel(
    private val userRepository: UserRepository
): ViewModel() {

    private val _users = MutableLiveData<List<Users>>()
    val users: LiveData<List<Users>> = _users

    fun fetchUsersList(){
        viewModelScope.launch {
            val remoteData = userRepository.fetchRemoteDataUsers()
            _users.postValue(remoteData)
        }
    }
}
