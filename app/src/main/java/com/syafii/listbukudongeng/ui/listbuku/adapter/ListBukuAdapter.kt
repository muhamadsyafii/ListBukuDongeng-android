package com.syafii.listbukudongeng.ui.listbuku.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.syafii.listbukudongeng.databinding.ItemBookBinding
import com.syafii.listbukudongeng.model.Book

class ListBukuAdapter : RecyclerView.Adapter<ListBukuAdapter.ViewHolder>() {

    private var listItem = mutableListOf<Book>()

    fun setItemBook(book: List<Book>) {
        listItem.clear()
        listItem.addAll(book)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemBookBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bindData(listItem[position])
    }

    override fun getItemCount(): Int {
        return listItem.size
    }


    class ViewHolder(val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(data : Book){
            binding.run {
                sivBook.setImageResource(data.image)
                tvTitle.text = data.judulBuku
                tvTahun.text = data.tahun
                tvPenerbit.text = data.penerbit
            }
        }
    }
}
