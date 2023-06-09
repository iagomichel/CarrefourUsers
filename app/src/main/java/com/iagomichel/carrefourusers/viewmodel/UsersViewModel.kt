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

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _onError = MutableLiveData<String>()
    val error: LiveData<String> = _onError

    fun fetchUsersList(){
        viewModelScope
            .launch {
                _loading.postValue(true)
                runCatching {
                    _users.postValue(userRepository.fetchRemoteDataUsers())
                }.onSuccess {
                    _loading.postValue(false)
                }.onFailure { error ->
                    _loading.postValue(false)
                    _onError.postValue(error.message)
                }
            }
    }
}
