package com.example.carlist.views

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.carlist.R

class FormActivity : AppCompatActivity() {
    lateinit var kwh_field : EditText
    lateinit var km_field : EditText
    lateinit var btn_calculate : Button
    lateinit var result_field: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_acitivity)
        setViews()
        setListeners()
    }

    private fun setListeners() {
        btn_calculate.setOnClickListener {
            val result = getValues()
            result_field.text = formatNumber(result.toString())
            result_field.visibility = View.VISIBLE
            kwh_field.text.clear()
            km_field.text.clear()
        }
    }

    private fun formatNumber(result: String): String {
        return result_field.text.toString().replace("VAR_RESULT", R.string.result.toString()).replace("VAR_PRICE", result)
    }

    private fun getValues() : Float {
        val kwh_value = kwh_field.text.toString().toFloat()
        val km_value = km_field.text.toString().toFloat()
        return calculate(kwh_value, km_value)
    }

    private fun calculate(kwhValue: Float, kmValue: Float) : Float {
        return kwhValue / kmValue
    }

    private fun setViews() {
        kwh_field = findViewById(R.id.et_khw)
        km_field = findViewById(R.id.et_km)
        btn_calculate = findViewById(R.id.btn_calculate)
        result_field = findViewById(R.id.tv_result)
    }
}