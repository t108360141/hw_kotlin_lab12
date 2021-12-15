package com.example.myapplication

import android.app.Service
import android.content.Intent
import android.os.IBinder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

import kotlinx.coroutines.delay

class MyService : Service() {
    override fun onCreate() {
        super.onCreate()
        val intent = Intent(this, SecActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        GlobalScope.launch (Dispatchers.Main){
            try {
                delay(3000)
                startActivity(intent)

            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }


    }

    override fun onStartCommand(intent: Intent,
                                flags: Int, startid: Int): Int {
        return START_NOT_STICKY
    }
    override fun onBind(intent: Intent): IBinder? = null
}