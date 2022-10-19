package com.example.unnamedgroup12project

import android.app.Application
import com.example.unnamedgroup12project.database.ProjectDatabase

class ProjectApplication : Application() {
    val db by lazy { ProjectDatabase.getInstance(this) }
}