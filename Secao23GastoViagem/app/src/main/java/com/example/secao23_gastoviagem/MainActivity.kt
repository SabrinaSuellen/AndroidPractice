package com.example.secao23_gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_calcular.setOnClickListener(this)


    }

    override fun onClick(viewId: View) {
        calculate()
    }

    private fun calculate() {
        val distance = input_distancia.text.toString().toFloat()
        val preco = input_preco.text.toString().toFloat()
        val autonomy = input_autonomia.text.toString().toFloat()
        var value: Float = 0.0f

        if(autonomy > 0)
            value = (distance * preco) / autonomy
        textview_totalrs.text = "R$ ${"%.2f".format(value)}"


    }

}