package com.syafii.listbukudongeng.ui.listbuku

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.syafii.listbukudongeng.data.listBook
import com.syafii.listbukudongeng.databinding.ActivityListBukuBinding
import com.syafii.listbukudongeng.ui.listbuku.adapter.ListBukuAdapter

class ListBukuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListBukuBinding
    private val adapter by lazy { ListBukuAdapter() }

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
            rvBook.adapter = adapter
            adapter.setItemBook(listBook)

            swipeRefresh.setOnRefreshListener {
                adapter.setItemBook(listBook)
                adapter.notifyDataSetChanged()
                swipeRefresh.isRefreshing = false
            }
        }
    }
}
