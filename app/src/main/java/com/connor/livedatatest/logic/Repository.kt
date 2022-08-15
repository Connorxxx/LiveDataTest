package com.connor.livedatatest.logic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.connor.livedatatest.model.User

object Repository {

    fun getUser(userId: String): LiveData<User> {
        val liveData = MutableLiveData<User>()
        liveData.value = User(userId, userId, 0)
        return liveData
    }
}