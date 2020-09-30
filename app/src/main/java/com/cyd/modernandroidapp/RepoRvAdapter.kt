package com.cyd.modernandroidapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cyd.modernandroidapp.databinding.RvItemRepoBinding
import com.cyd.modernandroidapp.model.Repo

/**
 * Created by cyd on 2020/9/30.
 */
class RepoRvAdapter(private var repoList : ArrayList<Repo>,private var listener: OnItemClickListener?)
    : RecyclerView.Adapter<RepoRvAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater =LayoutInflater.from(parent.context)
        val binding = RvItemRepoBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return repoList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(repoList.get(position),listener)
    }

    class ViewHolder(private var binding : RvItemRepoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(repo : Repo , listener: OnItemClickListener?) {
            binding.repo = repo
            if(listener != null) {
                binding.root.setOnClickListener { _ -> listener.onItemClick(layoutPosition) }
            }
            binding.executePendingBindings()
        }

    }
    interface OnItemClickListener {
        fun onItemClick(position : Int)

    }

    fun updateData(repoList: ArrayList<Repo>) {
        this.repoList = repoList
        notifyDataSetChanged()
    }


}