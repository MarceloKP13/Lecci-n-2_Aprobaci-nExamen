package com.example.aprobacion

import android.os.Bundle
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

        val nota = findViewById<EditText>(R.id.nota)
        val verificar = findViewById<Button>(R.id.verificar)
        val aprobacion = findViewById<TextView>(R.id.aprobacion)

        verificar.setOnClickListener {
            val textoNota = nota.text.toString()
            if (textoNota.isNotEmpty()){
                val nota = textoNota.toInt()
                if (nota >= 70){
                    aprobacion.text="Aprobado !!FELICIDADES¡¡"
                }else{
                    aprobacion.text="Reprobado, lo siento."
                }
        }else{
            aprobacion.text="Ingresa una calificación valida"
            }
        }
    }
}