package com.dacha.taskmanager1.data.local

import android.content.Context
import android.content.SharedPreferences

class PrefOnBoarding(private val context: Context) {

    private var pref : SharedPreferences = context.getSharedPreferences(PREF_NAME , Context.MODE_PRIVATE)


    fun isonBoardingShow():Boolean{
        return pref.getBoolean(SHOW_BOARDING , false)
    }
    fun saveOnBoardingShow(isShow: Boolean){
        pref.edit().putBoolean(SHOW_BOARDING , isShow).apply()
    }

    companion object{
        const val PREF_NAME = "pref.task"
        const val SHOW_BOARDING = "board"
    }
}