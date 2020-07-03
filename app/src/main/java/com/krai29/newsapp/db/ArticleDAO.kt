package com.krai29.newsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.krai29.newsapp.model.Article

@Dao
interface ArticleDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article) : Long

    @Delete
    suspend fun deleteArticle(article: Article)

    @Query("SELECT * FROM articles")
    fun getAllArticles() : LiveData<List<Article>>
}