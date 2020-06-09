package com.example.activitytutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object{
        val TAG : String = "[DEBUG] MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, object{}.javaClass.enclosingMethod?.name)
        setContentView(R.layout.activity_main)

        btn_main.setOnClickListener {
            startActivity(Intent(this, NextActivity::class.java))
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, object{}.javaClass.enclosingMethod?.name)
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, object{}.javaClass.enclosingMethod?.name)
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, object{}.javaClass.enclosingMethod?.name)
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, object{}.javaClass.enclosingMethod?.name)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, object{}.javaClass.enclosingMethod?.name)
    }


}
