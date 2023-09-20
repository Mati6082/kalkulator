package com.example.kalkulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var wysw: TextView
    var mem: Double? = null
    var dzialanie: String? = null
    var test:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        wysw = findViewById(R.id.display)
    }

    fun addNumber(v: View) {
        var press: String = ""
        if (wysw.text == "0")
            wysw.text = ""
        var pom = wysw.text
        when (v.id) {
            R.id.button0 -> press = "0"
            R.id.button1 -> press = "1"
            R.id.button2 -> press = "2"
            R.id.button3 -> press = "3"
            R.id.button4 -> press = "4"
            R.id.button5 -> press = "5"
            R.id.button6 -> press = "6"
            R.id.button7 -> press = "7"
            R.id.button8 -> press = "8"
            R.id.button9 -> press = "9"
            R.id.button_plus -> {
                if (mem == null) {
                    mem = wysw.text.toString().toDouble()
                    dzialanie = "+"
                    wysw.text = ""
                } else {
                    pom =
                        wykonaj_dzialanie(dzialanie, wysw.text.toString().toDouble()).toString()
                    mem = null
                    test = true
                }
            }
        }
        if (mem != null && test == false) {
            wysw.text = ""
            test = true
        }
        else
            wysw.text = pom.toString() + press
    }

    private fun wykonaj_dzialanie(dzialanie: String?, toDouble: Double): Double? {
        when (dzialanie) {
            "+" -> return toDouble + mem!!
            "-" -> return toDouble + mem!!
            "*" -> return toDouble + mem!!
            "/" -> return toDouble + mem!!
        }
        return null
    }

    fun clear(v: View) {
        wysw.text = "0"
    }
}