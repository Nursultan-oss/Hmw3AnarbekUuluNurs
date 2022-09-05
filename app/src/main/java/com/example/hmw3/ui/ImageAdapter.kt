package com.example.hmw3.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.hmw3.databinding.ImagetemBinding
import com.example.hmw3.ui.model.ImageModel

class ImageAdapter(private val list: List<ImageModel> ):
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {






    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding=ImagetemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
       holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
       return list.size
    }
    inner class ImageViewHolder(private var binding: ImagetemBinding ):RecyclerView.ViewHolder(binding.root){
        fun onBind(model:ImageModel){
            binding.image.load(model.largeImageURL)
        }
    }
}