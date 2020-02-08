package art.verylonely.clicker

import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.new_current.*


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        loadTheme()
        setContentView(R.layout.new_current)
        loadState()

        val face: Typeface = Typeface.createFromAsset(assets, "fonts/pixel_font.ttf")
        counter.setTypeface(face)
        darkthemeSwitch.setTypeface(face)

        background.setOnClickListener { countString() }

        val pref = getSharedPreferences("pref", Context.MODE_PRIVATE)
        darkthemeSwitch.isChecked = pref.getBoolean("checked", false)

        darkthemeSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked)
                saveTheme(true)
            else
                saveTheme(false)
            Toast.makeText(this, R.string.restartapp, Toast.LENGTH_SHORT).show()
        }

    }


    fun countString (){


        var count: Int = Integer.parseInt(counter.text.toString())

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

    private fun saveTheme(boolean: Boolean){
        val pref = getSharedPreferences("pref", Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putBoolean("checked", boolean)
        editor.apply()
    }


    fun loadTheme(){
        val pref = getSharedPreferences("pref", Context.MODE_PRIVATE)
        val dark_theme = pref.getBoolean("checked", false)

        if(dark_theme)
            setTheme(R.style.DarkTheme)
        else
            setTheme(R.style.AppTheme)
    }



}
