package com.nisha.githubuserinfo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
     val user = MutableLiveData<GithubUser?>()
    val error = MutableLiveData<String?>()

    private val githubService = GithubService.create()

    fun fetchUser(username: String) {
        viewModelScope.launch {
            try {
                val fetchedUser = githubService.getUser(username)
                user.value = fetchedUser
                error.value = null
            } catch (e: Exception) {
                user.value = null
                error.value = "User not found or an error occurred.."
            }
        }
    }
}