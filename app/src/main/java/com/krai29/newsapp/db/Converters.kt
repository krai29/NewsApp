package com.krai29.newsapp.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.krai29.newsapp.model.Source

class Converters {

    @TypeConverter
    fun fromSource(source : Source):String{
        return Gson().toJson(source)
    }

    @TypeConverter
    fun toSource(value:String):Source{
        return Gson().fromJson(value,Source::class.java)
    }
}