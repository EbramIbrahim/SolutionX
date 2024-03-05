package com.example.solutionx.utils

import android.os.Environment
import android.util.Log
import com.example.solutionx.BuildConfig
import java.io.File

object Logger {

    private var isLoggerEnables: Boolean = true
    private var isWrittenEnables: Boolean = false

    private fun enableLogging() {
        isLoggerEnables = true
    }

    private fun disableLogging() {
        isLoggerEnables = false
    }

    fun log(loggerType: LoggerType) {
        when (loggerType) {
            is LoggerType.D -> {
                if (isLoggerEnables) Log.d(loggerType.DTag, loggerType.DMessage)
            }

            is LoggerType.E -> {
                if (isLoggerEnables) Log.e(loggerType.ETag, loggerType.EMessage)
            }

            is LoggerType.I -> {
                if (isLoggerEnables) Log.i(loggerType.ITag, loggerType.IMessage)

            }

            is LoggerType.W -> {
                if (isLoggerEnables) Log.w(loggerType.WTag, loggerType.WMessage)
            }
        }
        if (isWrittenEnables) {
            logToFile(loggerType.message)
        }

    }

    fun logState() {
        when (BuildConfig.FLAVOR) {
            "logCat" -> enableLogging()
            "logWriter" -> isWrittenEnables = true
            "production" -> disableLogging()
        }
    }

    fun logToFile(logMessage: String) {
        try {
            val file = File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                "SolutionX/log.txt"
            )
            file.appendText("$logMessage\n")
            log(LoggerType.D("TAG", file.toString()))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}