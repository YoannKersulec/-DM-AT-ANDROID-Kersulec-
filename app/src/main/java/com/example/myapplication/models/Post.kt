package com.example.myapplication.models

data class Post (
    val userId: Int = 0,
    val id: Int? = null,
    val title: String? = null,
    val body: String? = null
)