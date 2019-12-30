package online.verylonely.clicker

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.new_current.*


class MainActivity : AppCompatActivity() {

    fun loadTheme(){
        val pref = getSharedPreferences("pref", Context.MODE_PRIVATE)
        val theme = pref.getInt("theme", 0)

            if(theme == 0)
                setTheme(R.style.AppTheme)
            if(theme == 2)
                setTheme(R.style.DarkTheme)
            if(theme == 1)
                setTheme(R.style.WhiteTheme)
    }



    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        loadTheme()
        setContentView(R.layout.new_current)
        loadState()
        var blue: Button = findViewById(R.id.blue)
        var white: Button = findViewById(R.id.white)
        var dark: Button = findViewById(R.id.dark)

        blue.setOnClickListener { saveTheme(0) }
        white.setOnClickListener { saveTheme(1) }
        dark.setOnClickListener { saveTheme(2) }


    }


    fun countString (view: View){


        val countString = counter.text.toString()

        var count: Int = Integer.parseInt(countString)
        count++

        counter.text = count.toString()

        saveState()

    }


    private fun saveState(){
        val pref = getSharedPreferences("pref", Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putString("counter", counter.text.toString())
        editor.apply()
    }

    private fun loadState(){
        val pref = getSharedPreferences("pref", Context.MODE_PRIVATE)
        val ctr = pref.getString("counter", "0")
        counter.text = ctr.toString()
    }

    private fun saveTheme(int: Int){
        val pref = getSharedPreferences("pref", Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putInt("theme", int)
        editor.apply()

        Toast.makeText(this, R.string.restartapp, Toast.LENGTH_SHORT).show()
    }



}
