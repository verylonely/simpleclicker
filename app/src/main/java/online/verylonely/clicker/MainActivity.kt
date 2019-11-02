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
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun donateClick(view: View){

        val wallet: AutoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.wallet)
        val supportBtn: TextView = findViewById<TextView>(R.id.support)

        supportBtn.isInvisible = true;
        wallet.isVisible = true;

    }

    fun countString (view: View){


        val countString = counter.text.toString()

        var count: Int = Integer.parseInt(countString)
        count++

        counter.text = count.toString()

        val wallet: AutoCompleteTextView = findViewById(R.id.wallet)
        val supportBtn: TextView = findViewById(R.id.support)

        if(wallet.isVisible){
            wallet.isInvisible = true;
            supportBtn.isVisible = true;
        }

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



}
