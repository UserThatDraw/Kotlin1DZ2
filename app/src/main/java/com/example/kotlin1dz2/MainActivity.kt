package com.example.kotlin1dz2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin1dz2.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val photos = arrayListOf(
            getString(R.string.pic1),
            getString(R.string.pic2),
            getString(R.string.pic3),
            getString(R.string.pic4),
            getString(R.string.pic5))

        initView()
        clickBtn(photos)
    }

    private fun clickBtn(photos: ArrayList<String>) {
        binding.addBtn.setOnClickListener{
            val image = binding?.editTxt?.text.toString().trim()
            photos.add(image)
        }

        binding.randomBtn.setOnClickListener{
            val randomIndex = Random(1).nextInt(photos.size)
            setImage(photos[randomIndex])
        }
    }

    private fun initView() {

        val url = getString(R.string.pic_test)

        setImage(url)
    }

    private fun setImage(url: String) {
        Picasso.get().load(url)
            .error(R.drawable.ic_launcher_background)
            .placeholder(R.drawable.ic_launcher_foreground)
            .resize(100, 100)
            .centerCrop()
            .into(binding.piked)
    }
}