package com.example.android_practice_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_practice_5.databinding.ActivityMainBinding
import com.example.android_practice_5.databinding.ItemLayoutBinding

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.loadItems()

        viewModel.components.observe(this, {
            binding.rvList.apply {
                adapter = ComponentAdapter(it)
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        })
    }
}