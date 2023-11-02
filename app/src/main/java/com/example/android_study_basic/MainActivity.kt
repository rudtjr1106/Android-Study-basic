package com.example.android_study_basic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import com.example.android_study_basic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private var type : Type = Type.CM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.bind = this

        setButton()
        editTextChanged()
    }

    fun setButton(){
        binding.apply {
            imageButtonSwitch.setOnClickListener {
                when(type){
                    Type.CM -> switchMeter()
                    Type.M -> switchCMeter()
                }
            }
        }
    }

    fun switchMeter(){
        binding.apply {
            type = Type.M
            editTextInput.hint = "m를 입력하세요"
            textViewUnit.text = "m"
            textViewResultUnit.text = "cm"
        }
    }

    fun switchCMeter(){
        binding.apply {
            type = Type.CM
            editTextInput.hint = "cm를 입력하세요"
            textViewUnit.text = "cm"
            textViewResultUnit.text = "m"
        }
    }

    fun editTextChanged(){
        binding.apply {
            editTextInput.addTextChangedListener {
                if(!editTextInput.text.isNullOrEmpty()){
                    textViewResult.text = (editTextInput.text.toString().toDouble()  * type.unit).toString()
                }
                else{
                    textViewResult.text = "0"
                }
            }
        }
    }
}

enum class Type(val unit: Double){
    CM(0.01), M(100.00)
}