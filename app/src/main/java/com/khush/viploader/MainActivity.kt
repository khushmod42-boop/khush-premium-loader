package com.khush.viploader

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {
    private val bg = Color.rgb(10, 10, 12)
    private val red = Color.rgb(225, 28,  forty())
    private fun forty() = 40

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = bg
        window.navigationBarColor = bg

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(28, 32, 28, 32)
            setBackgroundColor(bg)
        }
        val brand = TextView(this).apply {
            text = "KHUSH"
            textSize = 38f
            setTextColor(Color.WHITE)
            typeface = Typeface.create("sans-serif-black", Typeface.BOLD)
            gravity = Gravity.CENTER
        }
        val title = TextView(this).apply {
            text = "PREMIUM LOADER"
            textSize = 20f
            letterSpacing = 0.18f
            setTextColor(red)
            typeface = Typeface.DEFAULT_BOLD
            gravity = Gravity.CENTER
        }
        val subtitle = TextView(this).apply {
            text = "RED DEVIL EDITION  •  LICENSE ACCESS"
            textSize = 11f
            setTextColor(Color.LTGRAY)
            gravity = Gravity.CENTER
        }
        val key = EditText(this).apply {
            hint = "Enter your license key"
            setHintTextColor(Color.GRAY)
            setTextColor(Color.WHITE)
            textSize = 16f
            singleLine = true
            setPadding(18, 16, 18, 16)
            setBackgroundColor(Color.rgb(35, 25, 27))
        }
        val login = Button(this).apply {
            text = "VERIFY LICENSE"
            textSize = 15f
            setTextColor(Color.WHITE)
            setBackgroundTintList(android.content.res.ColorStateList.valueOf(red))
            setOnClickListener {
                val value = key.text.toString().trim()
                if (value.isEmpty()) {
                    Toast.makeText(this@MainActivity, "Please enter your license key", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@MainActivity,
                        "Demo UI only: connect a secure license server to verify keys.",
                        Toast.LENGTH_LONG).show()
                }
            }
        }
        val footer = TextView(this).apply {
            text = "Secure key verification • Device binding • Expiry status\nBackend connection required"
            textSize = 12f
            setTextColor(Color.LTGRAY)
            gravity = Gravity.CENTER
        }
        root.addView(brand, lp(-1, -2))
        root.addView(title, lp(-1, -2))
        root.addView(subtitle, lp(-1, -2).apply { bottomMargin = 36 })
        root.addView(key, lp(-1, -2).apply { bottomMargin = 16 })
        root.addView(login, lp(-1, -2).apply { bottomMargin = 28 })
        root.addView(footer, lp(-1, -2))
        setContentView(root)
    }

    private fun lp(w: Int, h: Int) = LinearLayout.LayoutParams(w, h).apply {
        topMargin = 8
    }
}
