package com.connor.livedatatest.model

import com.google.gson.annotations.SerializedName

class RepoResponse {
    @SerializedName("item") val items: List<Repo> = emptyList()
}