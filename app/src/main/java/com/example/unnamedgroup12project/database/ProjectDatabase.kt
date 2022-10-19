package com.example.unnamedgroup12project.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * @Database(entities = [User::class], version = 1)
abstract class ProjectDatabase : RoomDatabase() {
abstract fun projectDao(): ProjectDao
}
 */

@Database(entities = [ProjectEntity::class], version = 2)
abstract class ProjectDatabase : RoomDatabase() {

    abstract fun projectDao() : ProjectDAO

    companion object {

        @Volatile
        private var INSTANCE: ProjectDatabase? = null

        fun getInstance(context: Context): ProjectDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ProjectDatabase::class.java, "project-db"
            ).fallbackToDestructiveMigration()
                .build()
    }
}