package com.app.opticool.data.di

import android.content.Context
import com.app.opticool.data.EyeglassRepository
import com.app.opticool.data.preferences.UserPreferences
import com.app.opticool.data.preferences.dataStore
import com.app.opticool.data.retrofit.ApiConfig
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

object Injection {
    fun provideRepository(context: Context): EyeglassRepository = runBlocking {
        val pref = UserPreferences.getInstance(context.dataStore)
        val user = pref.getLoginToken().first()
        val apiService = ApiConfig.getApiService(user)
        EyeglassRepository.getInstance(apiService, pref)
    }
}