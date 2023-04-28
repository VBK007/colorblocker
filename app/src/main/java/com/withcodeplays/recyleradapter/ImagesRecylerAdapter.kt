package com.withcodeplays.recyleradapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.withcodeplays.R
import com.withcodeplays.databinding.ImagelistBinding
import com.withcodeplays.models.HomeFragmentDataModels
import timber.log.Timber

class ImagesRecylerAdapter(var arrayListData: java.util.ArrayList<HomeFragmentDataModels>) :
    RecyclerView.Adapter<BaseInnerViewHolders>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseInnerViewHolders {
        return ImageListViewHolder(
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.imagelist,parent,false)
        )
    }

    override fun getItemCount() = arrayListData.size

    override fun onBindViewHolder(holder: BaseInnerViewHolders, position: Int) {
        holder.bind(position, this)
    }

    inner class ImageListViewHolder(var binding: ImagelistBinding) : BaseInnerViewHolders(binding) {
        override fun bind(position: Int, adapter: ImagesRecylerAdapter) {
            binding.apply {
                val lData = arrayListData[position]
              Glide.with(localImages.context).load(lData.uriForImage).into(localImages)
            }
        }
    }
}


abstract class BaseInnerViewHolders(var bind: ViewDataBinding) :
    RecyclerView.ViewHolder(bind.root) {
    abstract fun bind(
        position: Int,
        adapter: ImagesRecylerAdapter
    )

    open fun bindWithPayload(
        absoluteAdapterPosition: Int,
        adapter: ImagesRecylerAdapter,
        payloads: MutableList<Any>
    ) {
        Timber.d("TAG", "bindWithPayload: $payloads")
    }

}