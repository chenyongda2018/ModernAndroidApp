package com.cyd.modernandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.cyd.modernandroidapp.databinding.ActivityMainBinding
import com.cyd.modernandroidapp.viewmodel.MainViewModel

class MainActivity : AppCompatActivity(), RepoRvAdapter.OnItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private var adapter = RepoRvAdapter(arrayListOf(), this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this, R.layout.activity_main
        )

        var repoViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        binding.repoViewModel = repoViewModel;
        binding.executePendingBindings()

        binding.repoRv.layoutManager = LinearLayoutManager(this)
        binding.repoRv.adapter = adapter
        repoViewModel.repoList.observe(this, Observer {
            it?.let {
                adapter.updateData(it)
            }
        })
        repoViewModel.refreshData()


    }

    override fun onItemClick(position: Int) {

    }

}
