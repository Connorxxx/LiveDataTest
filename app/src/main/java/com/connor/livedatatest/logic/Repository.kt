package com.connor.livedatatest.logic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.connor.livedatatest.api.GitHubService
import com.connor.livedatatest.model.Repo
import com.connor.livedatatest.model.User
import kotlinx.coroutines.flow.Flow

object Repository {

    private const val PAGE_SIZE = 50

    private val gitHubService = GitHubService.create()

    fun getPagingData(): Flow<PagingData<Repo>> {
        return Pager(
            config = PagingConfig(PAGE_SIZE),
            pagingSourceFactory = { RepoPagingSource(gitHubService) }
        ).flow
    }

    fun getUser(userId: String): LiveData<User> {
        val liveData = MutableLiveData<User>()
        liveData.value = User(userId, userId, 0)
        return liveData
    }
}