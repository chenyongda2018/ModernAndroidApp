package com.cyd.modernandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.databinding.DataBindingUtil
import com.cyd.modernandroidapp.databinding.ActivityMainBinding
import com.cyd.modernandroidapp.model.Repo

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(
                this, R.layout.activity_main)
        var repo = Repo("ModernAndroidApp","chenyongda",true,
            100)

        binding.repo = repo
        binding.executePendingBindings()


    }

}
