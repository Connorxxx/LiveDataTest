package com.connor.livedatatest.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.connor.livedatatest.logic.Repository
import com.connor.livedatatest.model.User

class SharedViewModel : ViewModel() {

    private val userIdLiveData = MutableLiveData<String>()

    val user: LiveData<User> = Transformations.switchMap(userIdLiveData) {
        Repository.getUser(it)
    }

    fun getUser(userId: String) {
        userIdLiveData.value = userId
    }
}