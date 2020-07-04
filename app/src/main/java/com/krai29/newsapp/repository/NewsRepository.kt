package com.krai29.newsapp.repository

import com.krai29.newsapp.api.RetrofitInstance
import com.krai29.newsapp.db.ArticlesDatabase
import com.krai29.newsapp.model.Article

class NewsRepository(
    val db : ArticlesDatabase
) {

    suspend fun getBreakingNews(countryCode:String, pageNumber:Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery : String,pageNumber : Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    suspend fun delete(article: Article) = db.getArticleDao().deleteArticle(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()
}