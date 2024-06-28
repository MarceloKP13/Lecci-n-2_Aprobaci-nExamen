package com.example.clasificadorfrutas

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val nombrefruta = findViewById<EditText>(R.id.nombrefruta)
        val boton = findViewById<Button>(R.id.boton)
        val colorfruta = findViewById<TextView>(R.id.colorfruta)

        boton.setOnClickListener {
            val fruta = nombrefruta.text.toString().trim().lowercase()
            var color = ""
            var colorTexto = Color.BLACK

            if (fruta == "manzana") {
                color = "Rojo"
                colorTexto = Color.RED
            }else if (fruta == "banana"){
                color = "Amarillo"
                colorTexto = Color.YELLOW
            }else if (fruta == "naranja"){
                color = "Naranaja"
                colorTexto = Color.rgb(255,165,0)
            }else if (fruta == "uva"){
                color = "Morado"
                colorTexto = Color.rgb(128,0,128)
            }else if (fruta == "kiwi"){
                color = "Verde"
                colorTexto = Color.GREEN
            }else if (fruta == "piña"){
                color = "Amarillo"
                colorTexto = Color.YELLOW
            }else {
                color = "Fruta desconocida"
                colorTexto = Color.RED
            }
            val mensaje = "El color de la fruta '$fruta' es: $color"

            val spannableString = SpannableString(mensaje)
            val colorSpan = ForegroundColorSpan(colorTexto)
            val startIndex = mensaje.indexOf(color)
            val endIndex = startIndex + color.length
            spannableString.setSpan(colorSpan, startIndex, endIndex, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)

            colorfruta.text = spannableString
        }
    }
}