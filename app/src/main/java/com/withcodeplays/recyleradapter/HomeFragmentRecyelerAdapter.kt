package com.withcodeplays.recyleradapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.withcodeplays.R
import com.withcodeplays.databinding.GridTypeRecylserviewBinding
import com.withcodeplays.databinding.ListTypeRecylervirewLayoutBinding
import com.withcodeplays.models.HomeFragmentDataModels
import com.withcodeplays.viewmodels.ViewmodelDatamodels
import timber.log.Timber
import java.util.Collections

class HomeFragmentRecyelerAdapter(var listofData: ArrayList<ViewmodelDatamodels>) :
    RecyclerView.Adapter<BaseViewHolders>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolders {
        return when (viewType) {
            0 -> {
                LeftSideCouroselImages(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.grid_type_recylserview, parent, false
                    )
                )
            }
            else -> {
                TopToBottomSideCouroselImages(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.list_type_recylervirew_layout, parent, false
                    )
                )
            }
        }
    }

    override fun getItemCount() = listofData.size


    fun refreshData(listOfNewData: ArrayList<ViewmodelDatamodels>)
    {
      this.listofData = listOfNewData
      notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: BaseViewHolders, position: Int) {
        holder.bind(adapter = this, position = holder.adapterPosition)
    }

    override fun getItemViewType(position: Int) = listofData[position].itemType

    inner class LeftSideCouroselImages(var binding: GridTypeRecylserviewBinding) :
        BaseViewHolders(binding) {
        override fun bind(position: Int, adapter: HomeFragmentRecyelerAdapter) {
            val lData = listofData[position]
           binding.apply {
               txtTopHeading.apply {
                   when
                   {
                       !lData.listOfRandom20Images.isNullOrEmpty()->
                       {
                           this.text = this.context.getString(R.string.random)
                       }
                       !lData.listOfRecent10Images.isNullOrEmpty()->
                       {
                           this.text = this.context.getString(R.string.recent)
                       }
                       !lData.listOfWhatsApp20Images.isNullOrEmpty()->
                       {
                           this.text = this.context.getString(R.string.tewntyImages)
                       }
                   }
               }
               mainRecyler.apply {
                   val lSetOfArrayData = ArrayList<HomeFragmentDataModels>()
                   lData.listOfRandom20Images?.let { lSetOfArrayData.addAll(it) }
                   lData.listOfRecent10Images?.let { lSetOfArrayData.addAll(it) }
                   lData.listOfWhatsApp20Images?.let { lSetOfArrayData.addAll(it) }
                   this.adapter = ImagesRecylerAdapter(lSetOfArrayData)
               }
           }
        }

    }


    inner class TopToBottomSideCouroselImages(var binding: ListTypeRecylervirewLayoutBinding) :
        BaseViewHolders(binding) {
        override fun bind(position: Int, adapter: HomeFragmentRecyelerAdapter) {
            val lData = listofData[position]
            binding.apply {
                txtTopHeading.text = txtTopHeading.context.getString(R.string.alliImages)
                mainRecyler.apply {
                    lData.listofImagesFromLocalUri?.let {  this.adapter = ImagesRecylerAdapter(it)}
                }
            }
        }

    }


}


abstract class BaseViewHolders(var bind: ViewDataBinding) :
    RecyclerView.ViewHolder(bind.root) {
    abstract fun bind(
        position: Int,
        adapter: HomeFragmentRecyelerAdapter
    )

    open fun bindWithPayload(
        absoluteAdapterPosition: Int,
        adapter: HomeFragmentRecyelerAdapter,
        payloads: MutableList<Any>
    ) {
        Timber.d("TAG", "bindWithPayload: $payloads")
    }

}