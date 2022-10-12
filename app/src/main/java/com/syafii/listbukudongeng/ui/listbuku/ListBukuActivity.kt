package com.syafii.listbukudongeng.ui.listbuku

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.syafii.listbukudongeng.data.listBook
import com.syafii.listbukudongeng.databinding.ActivityListBukuBinding
import com.syafii.listbukudongeng.model.Book
import com.syafii.listbukudongeng.ui.detail.DetailBookActivity
import com.syafii.listbukudongeng.ui.listbuku.adapter.ListBukuAdapter
import com.syafii.listbukudongeng.ui.listbuku.adapter.ListBukuNewAdapter
import com.syafii.listbukudongeng.ui.profile.ProfileActivity

class ListBukuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListBukuBinding
    private val adapter by lazy { ListBukuAdapter() }
    private val newAdapter by lazy { ListBukuNewAdapter().apply {
        onClickItem = { data ->
            handleOnclick(data)
        }
    } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBukuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        binding.run {
            val layoutManager =
                LinearLayoutManager(this@ListBukuActivity, RecyclerView.VERTICAL, false)
            rvBook.layoutManager = layoutManager
            rvBook.adapter = newAdapter
            newAdapter.submitList(listBook)

//            rvBook.adapter = adapter
//            adapter.setItemBook(listBook)

            swipeRefresh.setOnRefreshListener {
//                adapter.setItemBook(listBook)
//                adapter.notifyDataSetChanged()
                newAdapter.submitList(listBook)
                swipeRefresh.isRefreshing = false
            }

            siProfile.setOnClickListener {
                val intent = Intent(this@ListBukuActivity, ProfileActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun handleOnclick(data: Book) {
        val intent = Intent(this@ListBukuActivity, DetailBookActivity::class.java)
        intent.putExtra(KEY_DATA, data)
        startActivity(intent)
    }

    companion object {
        const val KEY_DATA = "key_data"
    }
}

