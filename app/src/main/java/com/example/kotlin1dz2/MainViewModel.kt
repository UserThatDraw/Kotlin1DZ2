package com.example.kotlin1dz2

import androidx.lifecycle.ViewModel
import java.util.*
import kotlin.collections.ArrayList

class MainViewModel : ViewModel() {


    var photos: ArrayList<String> = ArrayList()

    fun initialize() {
        photos = arrayListOf(
            "https://images.wallpaperscraft.ru/image/zakat_more_nebo_gorizont_115519_2048x1152.jpg",
            "https://trikky.ru/wp-content/blogs.dir/1/files/2021/01/31/dmqi_-xw4aedvtp.jpg",
            "https://pbs.twimg.com/media/EBltuf4WwAAftrd.jpg",
            "https://i.artfile.ru/2048x1363_660111_[www.ArtFile.ru].jpg",
            "https://proprikol.ru/wp-content/uploads/2020/06/krasivye-kartinki-zakaty-27.jpg",
            "https://i.artfile.ru/2048x1367_1163057_[www.ArtFile.ru].jpg"
        )
    }


    fun addList(image: String) {
        photos.add(image)
    }

    fun getImage() = photos[Random().nextInt(photos.size)]
}