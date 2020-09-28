package com.example.myapplication2

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.IBinder
import android.util.Log
import android.widget.Toast

private const val TAG = "MyService"
class MyService : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

   override fun onStart(intent: Intent?, startId: Int) {
        var n = 0
        if(intent != null) {
            n = intent.getIntExtra("N",n)
        }
        n = fibo(n);
        Log.w(TAG, "result:${n}")
        Intent().also { intent ->
            intent.setAction("com.example.myapplication2.MY_NOTIFICATION")
            intent.putExtra("res",n.toString())
            sendBroadcast(intent)
        }
    }
    private  fun  fibo(n: Int): Int {
        return when(n){
            0 -> 0
            1 -> 1
        else ->  fibo(n - 1) + fibo(n - 2)
        }
    }
}

