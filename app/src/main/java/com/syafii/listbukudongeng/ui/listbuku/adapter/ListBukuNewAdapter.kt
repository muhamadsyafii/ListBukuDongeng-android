package com.syafii.listbukudongeng.ui.listbuku.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.syafii.listbukudongeng.databinding.ItemBookBinding
import com.syafii.listbukudongeng.model.Book

class ListBukuNewAdapter : ListAdapter<Book, ListBukuNewAdapter.ListBukuViewHolder>(ListBukuDiffCallback()) {

    var onClickItem : ((Book) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ListBukuViewHolder {
        return ListBukuViewHolder(ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ListBukuViewHolder, position: Int) {
       holder.bindData(getItem(position))
    }


    inner class ListBukuViewHolder(val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(data : Book){
            binding.run {
                sivBook.setImageResource(data.image)
                tvTitle.text = data.judulBuku
                tvTahun.text = data.tahun
                tvPenerbit.text = data.penerbit

                binding.root.setOnClickListener {
                    onClickItem?.invoke(data)
                }
            }
        }
    }


    class ListBukuDiffCallback : DiffUtil.ItemCallback<Book>() {
        override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem.noBook == newItem.noBook
        }

        override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem == newItem
        }

    }
}
