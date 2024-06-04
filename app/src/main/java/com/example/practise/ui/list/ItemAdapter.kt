package com.example.practise.ui.list
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.practise.databinding.ItemViewBinding
import com.example.practise.model.data.All

class ItemAdapter(private val items: List<All>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(listItem: All) {
            binding.txtNumber.text = (adapterPosition + 4).toString()
            binding.txtCoin.text = listItem.giftcoin.toString()
            binding.txtName.text = listItem.first_name
            binding.txtGender.text = listItem.gender
            binding.txtLevel.text = listItem.level.toString()
            Glide.with(binding.root.context)
                .load(listItem.profile_pic)
                .into(binding.imgProfile)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = items[position]
        holder.bind(currentItem)
    }
    override fun getItemCount(): Int = items.size
}