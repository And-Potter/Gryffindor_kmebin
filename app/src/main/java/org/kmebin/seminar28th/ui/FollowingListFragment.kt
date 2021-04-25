package org.kmebin.seminar28th.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.kmebin.seminar28th.adapter.FollowingListAdapter
import org.kmebin.seminar28th.data.FollowingUserInfo
import org.kmebin.seminar28th.databinding.FragmentFollowingListBinding

class FollowingListFragment : Fragment() {

    private var _binding: FragmentFollowingListBinding? = null
    private val binding get() = _binding ?: error("View를 참조하기 위해 binding이 초기화되지 않았습니다.")
    private lateinit var followingListAdapter: FollowingListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFollowingListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        followingListAdapter = FollowingListAdapter()
        binding.userList.adapter = followingListAdapter

        followingListAdapter.userList.addAll(
            listOf(
                FollowingUserInfo(userImage = "blank", userId = "hello1"),
                FollowingUserInfo(userImage = "blank", userId = "hello2"),
                FollowingUserInfo(userImage = "blank", userId = "hello2"),
                FollowingUserInfo(userImage = "blank", userId = "hello2"),
            )
        )
        followingListAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}