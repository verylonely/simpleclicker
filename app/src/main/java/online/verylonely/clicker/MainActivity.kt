package online.verylonely.clicker

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
import android.R.id.edit
import android.content.Context
import android.content.SharedPreferences.Editor
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class MainActivity : AppCompatActivity() {

    val APP_PREFERENCES = "mysettings"
    val APP_PREFERENCES_COUNTER = "counter"
    lateinit var pref: SharedPreferences



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pref = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)
    }
    

    fun countString (view: View){


        val countString = counter.text.toString()

        var count: Int = Integer.parseInt(countString)
        count++

        counter.text = count.toString()

    }

    override fun onSaveInstanceState(outState: Bundle) {

        outState.run {
            putString("KEY", counter.text.toString())
        }

        super.onSaveInstanceState(outState)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        counter.text = savedInstanceState.getString("KEY")

    }

    override fun onPause() {
        super.onPause()

        val editor = pref.edit()
        val countString = counter.text.toString()
        var count: Int = Integer.parseInt(countString)
        editor.putInt(APP_PREFERENCES_COUNTER, count)
        editor.apply()
    }



}
