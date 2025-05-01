package com.example.idadedocachorro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var name: EditText
    private lateinit var idadeH: EditText
    private lateinit var resultado: TextView
    private lateinit var botaoMultiplicar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.edit_nome)
        idadeH = findViewById(R.id.edit_idade_H)
        resultado = findViewById(R.id.text_total_value)
        botaoMultiplicar = findViewById(R.id.button_calculate)

        botaoMultiplicar.setOnClickListener {
            val idadeTexto = idadeH.text.toString()
            val nomeCachorro = name.text.toString()

            if (idadeTexto.isNotEmpty() && nomeCachorro.isNotEmpty()) {
                val idade = idadeTexto.toInt()


                if (idade > 0) {

                    resultado.text = "O cachorro $nomeCachorro tem ${calculo(idade)} anos em idade de cachorro."

                    resultado.visibility = TextView.VISIBLE
                } else {

                    Toast.makeText(this, "A idade deve ser maior que 0", Toast.LENGTH_SHORT).show()
                }
            } else {

                Toast.makeText(this, "Por favor, insira o nome e a idade do cachorro", Toast.LENGTH_SHORT).show()

            }
        }
    }

    fun calculo(idadeH: Int): Int {
        return idadeH * 7
    }
}
