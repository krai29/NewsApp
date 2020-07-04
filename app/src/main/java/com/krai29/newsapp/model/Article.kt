package com.krai29.newsapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "articles")
data class Article(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source?,
    val title: String?,
    @PrimaryKey(autoGenerate = false)
    val url: String,
    val urlToImage: String?
) : Serializable