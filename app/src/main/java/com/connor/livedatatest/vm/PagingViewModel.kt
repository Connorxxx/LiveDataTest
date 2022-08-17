package com.connor.livedatatest.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.connor.livedatatest.logic.Repository
import com.connor.livedatatest.model.Repo
import kotlinx.coroutines.flow.Flow

class PagingViewModel : ViewModel() {

    fun getPagingData(): Flow<PagingData<Repo>> {
        return Repository.getPagingData().cachedIn(viewModelScope)
    }
}