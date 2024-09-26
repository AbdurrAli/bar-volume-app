package com.example.barvolume

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var editWidth: EditText
    private lateinit var editHeight: EditText
    private lateinit var editLength: EditText
    private lateinit var buttonCalculate: Button
    private lateinit var resultShow: TextView

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editWidth = findViewById(R.id.inpt_lebar)
        editHeight = findViewById(R.id.inpt_tinggi)
        editLength = findViewById(R.id.inpt_panjang)
        buttonCalculate = findViewById(R.id.btn_calculate)
        resultShow = findViewById(R.id.hasil_hitung)
        buttonCalculate.setOnClickListener(this)

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT)
            resultShow.text = result
        }
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btn_calculate) {
            val inputWidth = editWidth.text.toString().trim()
            val inputHeight = editHeight.text.toString().trim()
            val inputLength = editLength.text.toString().trim()
            var isEmptyFields = false
            if (inputLength.isEmpty()) {
                isEmptyFields = true
                editLength.error = "Input ini tidak boleh kosong"
            }
            if (inputWidth.isEmpty()) {
                isEmptyFields = true
                editLength.error = "Input ini tidak boleh kosong"
            }
            if (inputHeight.isEmpty()) {
                isEmptyFields = true
                editLength.error = "Input ini tidak boleh kosong"
            }
            if (!isEmptyFields) {
                val resultVolume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                resultShow.text = resultVolume.toString()
            }
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, resultShow.text.toString())
    }
}