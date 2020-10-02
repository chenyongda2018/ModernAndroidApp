package com.cyd.modernandroidapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.cyd.modernandroidapp.databinding.ActivityMainBinding
import com.cyd.modernandroidapp.inject.Inject
import com.cyd.modernandroidapp.viewmodel.MainViewModel
import com.cyd.modernandroidapp.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity(), RepoRvAdapter.OnItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModelFactory: MainViewModelFactory
    private var adapter = RepoRvAdapter(arrayListOf(), this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this, R.layout.activity_main
        )
        viewModelFactory = Inject.provideViewModelFactory(applicationContext)


        var repoViewModel = ViewModelProviders.of(this,viewModelFactory).get(MainViewModel::class.java)

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
