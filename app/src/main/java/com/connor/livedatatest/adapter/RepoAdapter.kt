package com.connor.livedatatest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.connor.livedatatest.R
import com.connor.livedatatest.databinding.ItemRepoBinding
import com.connor.livedatatest.model.Repo

class RepoAdapter : PagingDataAdapter<Repo, RepoAdapter.ViewHolder>(COMPARATOR) {

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Repo>() {
            override fun areItemsTheSame(oldItem: Repo, newItem: Repo) = oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Repo, newItem: Repo) = oldItem == newItem
        }
    }

    inner class ViewHolder(private val binding: ItemRepoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun getBinding(): ItemRepoBinding = binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemRepoBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_repo,
            parent,
            false
        )
        val holder = ViewHolder(binding)

        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val repo = getItem(position)
        if (repo != null) {
            holder.getBinding().m = repo
        }
    }
}