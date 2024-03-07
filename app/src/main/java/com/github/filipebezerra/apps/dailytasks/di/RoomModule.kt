package com.github.filipebezerra.apps.dailytasks.di

import android.content.Context
import androidx.room.Room
import com.github.filipebezerra.apps.dailytasks.data.database.DailyTasksDatabase
import com.github.filipebezerra.apps.dailytasks.data.database.TaskDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    @Singleton
    fun provideDailyTasksDatabase(@ApplicationContext context: Context): DailyTasksDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = DailyTasksDatabase::class.java,
            name = "daily_tasks_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTaskDao(dailyTasksDatabase: DailyTasksDatabase): TaskDao {
        return dailyTasksDatabase.taskDao()
    }
}
