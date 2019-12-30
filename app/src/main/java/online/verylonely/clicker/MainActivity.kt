package online.verylonely.clicker

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.new_current.*


class MainActivity : AppCompatActivity() {

    fun loadTheme(){
        val pref = getSharedPreferences("pref", Context.MODE_PRIVATE)
        val dark_theme = pref.getBoolean("checked", false)

            if(dark_theme)
                setTheme(R.style.DarkTheme)
            else
                setTheme(R.style.AppTheme)
    }



    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        loadTheme()
        setContentView(R.layout.new_current)
        loadState()
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

//    fun donateClick(view: View){
//
//        val wallet: AutoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.wallet)
//        val supportBtn: TextView = findViewById<TextView>(R.id.support)
//
//        supportBtn.isInvisible = true
//        wallet.isVisible = true
//
//    }

    fun countString (view: View){


        val countString = counter.text.toString()

        var count: Int = Integer.parseInt(countString)
        count++

        counter.text = count.toString()

        saveState()

//        val wallet: AutoCompleteTextView = findViewById(R.id.wallet)
//        val supportBtn: TextView = findViewById(R.id.support)
//
//        if(wallet.isVisible){
//            wallet.isInvisible = true
//            supportBtn.isVisible = true
//        }

    }

//    override fun onSaveInstanceState(outState: Bundle) {
//
//        outState.run {
//            putString("KEY", counter.text.toString())
//        }
//
//        super.onSaveInstanceState(outState)
//
//    }
//
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//
//        counter.text = savedInstanceState.getString("KEY")
//
//    }

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



}
