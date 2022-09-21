package com.manjilrawal.wishlist

data class Todo(
    val title: String,
    var isChecked: Boolean = false,
    val price : String,
    val url: String


)