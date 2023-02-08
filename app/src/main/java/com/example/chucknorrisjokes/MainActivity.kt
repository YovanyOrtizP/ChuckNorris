package com.example.chucknorrisjokes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chucknorrisjokes.databinding.ActivityMainBinding
import com.example.chucknorrisjokes.di.ChuckNorrisApp


class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        ChuckNorrisApp.chuckNorrisComponent.inject(this)
    }
}
