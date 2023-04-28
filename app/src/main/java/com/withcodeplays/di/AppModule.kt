package com.withcodeplays.di

import android.content.Context
import com.withcodeplays.familytracker.di.PreferenceManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.*

@Module
@InstallIn(SingletonComponent::class)
internal class AppModule {
    @Provides
    fun getCalendar() = Calendar.getInstance()

    @Provides
    fun preference(@ApplicationContext context: Context) = PreferenceManager(context)

}