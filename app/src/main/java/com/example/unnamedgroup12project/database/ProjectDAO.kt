package com.example.unnamedgroup12project.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ProjectDAO {

    /**
    @Query("SELECT * FROM my_table")
    fun getAll(): LiveData<List<Entity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entry : Entity)

    @Delete
    suspend fun deleteThis(entry : Entity?)
    **/
}