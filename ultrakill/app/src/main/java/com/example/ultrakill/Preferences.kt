package com.example.ultrakill

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

class Preferences(context: Context) {

    private val sharedPreferences = context.getSharedPreferences(
        Constants.STYLE,
        Context.MODE_PRIVATE
    )
    val editor = sharedPreferences.edit()

    fun guardarStyle(stylePoints: Int) {
        editor.putInt(Constants.STYLE, stylePoints)
        editor.apply()
    }

    fun cargarStyle() = sharedPreferences.getInt(Constants.STYLE, 0)

    fun reiniciar(){
        editor.clear()
        editor.apply()
    }

    fun restarStyle(stylePoints: Int) : Int {
        editor.putInt(Constants.STYLE, stylePoints - 1)
        editor.apply()
        return stylePoints - 1
    }
}