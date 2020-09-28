package com.example.myapplication2

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.ApplicationInfo
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

private const val TAG ="MainActivity";
class MainActivity : AppCompatActivity() {
    var n =0
    val br: BroadcastReceiver = MyReceiver()
    val filter = IntentFilter("com.example.myapplication2.MY_NOTIFICATION").apply { addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "Create")
        registerReceiver(br,filter)
    }

    override fun onSaveInstanceState(outState: Bundle){
        super.onSaveInstanceState(outState)
        outState.putInt("N", n + 1)
        Intent(this, MyService::class.java).also { intent ->
            stopService(intent)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        n = savedInstanceState.getInt("N")
        Log.w(TAG, "N:${n}")
        Intent(this, MyService::class.java).also { intent ->
            intent.putExtra("N",n)
            startService(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        registerReceiver(br, filter)
    }

    override fun onStop() {
        unregisterReceiver(br)
        super.onStop()
    }
}