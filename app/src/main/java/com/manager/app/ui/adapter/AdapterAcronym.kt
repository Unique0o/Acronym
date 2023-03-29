package com.manager.app.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.manager.app.R
import com.manager.app.databinding.ItemAcronymBinding
import com.manager.app.model.acronym.LfsItem

class AdapterAcronym(
    private var list: ArrayList<LfsItem>
) : RecyclerView.Adapter<AdapterAcronym.AcronymViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        AcronymViewHolder(
            DataBindingUtil.inflate<ItemAcronymBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item_acronym,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: AcronymViewHolder, position: Int) {
        //Here Data is Binding
        holder.rvBinding.acronym = list[position]
    }

    override fun getItemCount(): Int {
       return list.size
    }

    inner class AcronymViewHolder(val rvBinding: ItemAcronymBinding) :
        RecyclerView.ViewHolder(rvBinding.root)


    fun updateList(list:ArrayList<LfsItem>){
        this.list = list
        notifyDataSetChanged()
    }
}
