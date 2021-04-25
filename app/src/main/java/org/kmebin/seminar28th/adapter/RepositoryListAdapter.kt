package org.kmebin.seminar28th.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.kmebin.seminar28th.data.RepositoryInfo
import org.kmebin.seminar28th.databinding.ItemRepositoryBinding

class RepositoryListAdapter : RecyclerView.Adapter<RepositoryListAdapter.RepositoryViewHolder>() {

    var repositoryList = mutableListOf<RepositoryInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val binding =
            ItemRepositoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RepositoryViewHolder(binding)
    }

    override fun getItemCount(): Int = repositoryList.size

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.onBind(repositoryList[position])
    }

    class RepositoryViewHolder(
        private val binding: ItemRepositoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(repositoryInfo: RepositoryInfo) {
            binding.repositoryName.text = repositoryInfo.name
            binding.repositoryDescription.text = repositoryInfo.description
            binding.language.text = repositoryInfo.language
        }
    }
}