package com.nisha.githubuserinfo

import com.google.gson.annotations.SerializedName

data class GithubUser(
    val login: String,
    val followers: Int,
    val following: Int,
    @SerializedName("public_repos")
    val publicRepos: Int
)
