package com.iagomichel.carrefourusers.data.model

import com.squareup.moshi.Json

data class Users(
    val login: String,
    @Json(name = "avatar_url")
    val avatarUrl: String = ""
)
