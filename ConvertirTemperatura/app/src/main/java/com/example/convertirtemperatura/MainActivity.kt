package com.example.convertirtemperatura

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.convertirtemperatura.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.boton.setOnClickListener {

            val input = binding.grados.text.toString()
            if (input.isEmpty()) {
                binding.grados.error = "Espacio en blanco"
                return@setOnClickListener
            }

            val temperatura = input.toDouble()

            val resultado: Double = if (binding.decaf.isChecked) {

                celsiusToFahrenheit(temperatura)
            } else {

                fahrenheitToCelsius(temperatura)
            }


            binding.Resultado.text = String.format("El resultado es: %.2f %s", resultado, if (binding.decaf.isChecked) "°F" else "°C")
        }
    }

    private fun celsiusToFahrenheit(celsius: Double): Double {
        return celsius * 9 / 5 + 32
    }

    private fun fahrenheitToCelsius(fahrenheit: Double): Double {
        return (fahrenheit - 32) * 5 / 9
    }
}
