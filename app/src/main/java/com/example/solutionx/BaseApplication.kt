package com.example.solutionx

import android.app.Application
import com.example.solutionx.utils.Logger

class BaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Logger.logState()
    }
}