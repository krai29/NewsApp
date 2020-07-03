package com.krai29.newsapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.krai29.newsapp.model.Article

@Database(entities = [Article::class],version = 2)
@TypeConverters(Converters::class)
abstract class ArticlesDatabase : RoomDatabase() {

    abstract fun getArticleDao() : ArticleDAO

    companion object{

        @Volatile
        private var instance : ArticlesDatabase? = null

        operator fun invoke(context: Context) = instance?: synchronized(Any()){
            instance?:createDatabase(context).also{ instance = it}
        }

         fun createDatabase(context: Context) =
             Room.databaseBuilder(
                 context.applicationContext, ArticlesDatabase::class.java, "articledb.db"
             ).build()

    }
}