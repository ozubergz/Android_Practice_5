package com.example.android_practice_5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_practice_5.databinding.ItemLayoutBinding

class ComponentAdapter(private val dataSet: List<Component>) : RecyclerView.Adapter<ComponentAdapter.ComponentViewHolder>() {

    class ComponentViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(component: Component) {

            when(component) {
                is Component1 -> binding.tvText.text = component.text
                is Component2 ->  Glide.with(this.itemView).load(component.imageUrl).into(binding.ivUrl);
                is Component3 -> binding.tvTimestamp.text = component.timestamp.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComponentViewHolder {
        val view = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ComponentViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComponentViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}