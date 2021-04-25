package org.kmebin.seminar28th.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.kmebin.seminar28th.adapter.RepositoryListAdapter
import org.kmebin.seminar28th.data.RepositoryInfo
import org.kmebin.seminar28th.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var repositoryListAdapter: RepositoryListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureRepositoryList()
        configureNavigation()
    }

    private fun configureRepositoryList() {
        repositoryListAdapter = RepositoryListAdapter()
        binding.repositoryList.adapter = repositoryListAdapter

        repositoryListAdapter.repositoryList.addAll(
            listOf(
                RepositoryInfo(
                    name = "repository1",
                    description = "description1",
                    language = "kotlin"
                ),
                RepositoryInfo(
                    name = "repository2",
                    description = "description2",
                    language = "Python"
                ),
                RepositoryInfo(
                    name = "repository3",
                    description = "description3",
                    language = "JavaScript"
                ),
            )
        )
        repositoryListAdapter.notifyDataSetChanged()
    }

    private fun configureNavigation() {
        binding.moreBtn.setOnClickListener {
            val intent = Intent(this, UserInfoActivity::class.java)
            startActivity(intent)
        }
    }
}