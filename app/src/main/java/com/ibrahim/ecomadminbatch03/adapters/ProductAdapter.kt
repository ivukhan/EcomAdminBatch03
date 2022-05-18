package com.ibrahim.ecomadminbatch03.adapters

import android.media.browse.MediaBrowser
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ibrahim.ecomadminbatch03.databinding.ProductRowBinding
import com.ibrahim.ecomadminbatch03.models.Product

class ProductAdapter :ListAdapter<Product,ProductAdapter.ProductViewHolder>(ProductDiffUtil()){

    class ProductViewHolder(val binding:ProductRowBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(product: Product){
            binding.product = product
        }
    }

    class ProductDiffUtil : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ProductRowBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        )
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = getItem(position)
        holder.bind(product)
    }
}