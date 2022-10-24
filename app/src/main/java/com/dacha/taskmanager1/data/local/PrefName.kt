package com.dacha.taskmanager1.data.local

import android.content.Context
import android.content.SharedPreferences
import com.dacha.taskmanager1.ProfileFragment

class PrefName(private val context: Context) {

    private var pref : SharedPreferences = context.getSharedPreferences(PREF_NAME , Context.MODE_PRIVATE)


    fun isNameShow():Boolean{
        return pref.getBoolean(SHOW_NAME , false)
    }
    fun saveNameShow(isShow: Boolean){
        pref.edit().putBoolean(SHOW_NAME , isShow).apply()
    }

    companion object{
        const val PREF_NAME = "pref.name"
        const val SHOW_NAME = "name"
    }
}