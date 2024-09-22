package com.example.lab2

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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val output: TextView = findViewById(R.id.output)
        val input: EditText = findViewById(R.id.input)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener{
            val p = input.text.toString()
            val n = p.toFloatOrNull()

            if (n != null && n > 0){

                var i: Int = 1
                var j: Int = 1
                var k: Int = 1
                var sum: Float = 0.0f
                var scet: Int = 1
                while((1.0f/i) >= n){
                    for (j in 1..i){
                        k = k * j
                    }
                    sum = sum + 1.0f/k
                    i = i + 2
                    scet = scet + 1
                    k = 1
                }
                i = i - 2
                scet = scet - 1
                output.text = "Сумма: " + sum + " Последнее слогаемое: " + 1 + "/" + i + " Итерация: " + scet
            }
            else output.text = "Error"
        }
    }
}