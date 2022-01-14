package com.example.secao23_gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_calcular.setOnClickListener(this)


    }

    override fun onClick(viewId: View) {
        calculate()
    }

    private fun calculate() = if (validation()) {
        try {
            val distance = input_distancia.text.toString().toFloat()
            val preco = input_preco.text.toString().toFloat()
            val autonomy = input_autonomia.text.toString().toFloat()
            val value = (distance * preco) / autonomy
            textview_totalrs.text = "R$ ${"%.2f".format(value)}"

        } catch (nfe: NumberFormatException) {
            Toast.makeText(this, getString(R.string.informe_valor), Toast.LENGTH_LONG).show()
        }
    } else
        Toast.makeText(this, getString(R.string.preencha_campos), Toast.LENGTH_LONG).show()

    private fun validation(): Boolean = input_distancia.text.toString() != ""
            && input_preco.text.toString() != "" && input_autonomia.text.toString() != ""

}