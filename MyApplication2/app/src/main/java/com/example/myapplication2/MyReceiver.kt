package com.example.myapplication2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Parcelable
import android.util.Log
import android.widget.Toast
private const val TAG = "MyReceiver"
class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        var result = intent.getStringExtra("res");
        if (result != null) {
            Log.d(TAG, result)
            val toast = Toast.makeText(context, result.toString(), Toast.LENGTH_SHORT)
            toast.show()
        };
    }
}




