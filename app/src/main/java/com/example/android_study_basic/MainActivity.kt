package com.example.android_study_basic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.android_study_basic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    var counter : String = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.vm = this
        binding.textViewCounter.text = counter
        setButton()
    }

    fun setButton(){
        binding.apply {
            buttonReset.setOnClickListener {
                counter = "0"
                textViewCounter.text = counter
                println(counter)
            }

            buttonPlus.setOnClickListener {
                counter = (counter.toInt()+1).toString()
                textViewCounter.text = counter
                println(counter)
            }
        }
    }
}