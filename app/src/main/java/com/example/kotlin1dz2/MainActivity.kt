package com.example.kotlin1dz2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.kotlin1dz2.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.initialize()
        initView()
        clickBtn()
    }

    private fun clickBtn() {
        binding.addBtn.setOnClickListener {
            viewModel.addList(binding.editTxt.text.toString())
            binding.editTxt.setText("")
        }

        binding.randomBtn.setOnClickListener {
            setImage(viewModel.getImage())
        }
    }

    private fun initView() {
        setImage(getString(R.string.pic_test))
    }

    private fun setImage(url: String) {
        Picasso.get().load(url)
            .resize(100, 100)
            .centerCrop()
            .into(binding.piked)
    }
}