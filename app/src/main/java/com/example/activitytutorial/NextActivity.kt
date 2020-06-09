package com.example.activitytutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_next.*

class NextActivity : AppCompatActivity() {
    companion object{
        val TAG : String = "[DEBUG] NextActivity"
    }

    var intValue : Int? = null
    var stringValue : String? = null

    var observer = MyObserver(lifecycle)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)
        lifecycle.addObserver(observer)

        if(savedInstanceState == null)
            Log.d(TAG, object{}.javaClass.enclosingMethod?.name + " savedInstanceState is null")
        else
            Log.d(TAG, object{}.javaClass.enclosingMethod?.name + " savedInstanceState is not null")

        if(savedInstanceState != null){
            stringValue = savedInstanceState?.getString("STRING_KEY")
            intValue = savedInstanceState?.getInt("INT_KEY")
        }
        else {
            stringValue = "init"
            intValue = 0
        }

        Log.d(TAG, object{}.javaClass.enclosingMethod?.name + "gameState : " + stringValue)
        Log.d(TAG, object{}.javaClass.enclosingMethod?.name + "count : " + intValue)
        Log.d(TAG, object{}.javaClass.enclosingMethod?.name + " editText : " + textView.text.toString())

        btn_next.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        btn_change.setOnClickListener{
            textView.text = "Click!!!"
        }
        btn_email.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND).apply {
                putExtra(Intent.EXTRA_EMAIL, "sea5727@gamil.com")
            }
            startActivity(intent)
        }
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, object{}.javaClass.enclosingMethod?.name)
        if(savedInstanceState != null){
            stringValue = savedInstanceState?.getString("STRING_KEY")
            intValue = savedInstanceState?.getInt("INT_KEY")

        }
//        textView.text = savedInstanceState?.getString("TEXT_VIEW_KEY")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG, object{}.javaClass.enclosingMethod?.name)
        super.onSaveInstanceState(outState)
        stringValue = stringValue + "!"
        intValue = intValue?.plus(10)
        outState?.run{
            putString("STRING_KEY", stringValue)
            putInt("INT_KEY", intValue!!)
//            putString("TEXT_VIEW_KEY", textView.text.toString())
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
