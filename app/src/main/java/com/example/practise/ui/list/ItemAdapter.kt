package com.example.practise.ui.list
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practise.databinding.ItemViewBinding
import com.example.practise.model.data.All
import com.example.practise.model.data.Item
import kotlinx.coroutines.awaitAll

class ItemAdapter(private val items: List<All>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(listItem: All) {
            //binding.itemTextView.text = listItem.data.host_daily.all.map { it.first_name }.toString()

            var firstNames = listItem.first_name
            //binding.txtTop1.text = listItem.data.host_daily.top3[0].first_name
            //binding.txtTop2.text = listItem.data.host_daily.top3[1].first_name
            //binding.txtTop3.text = listItem.data.host_daily.top3[2].first_name
            binding.itemTextView.text = firstNames


            Log.e("json",firstNames)



            /*Glide.with(binding.root.context)
                .load(listItem.data.host_daily.top3[2].profile_pic)
                .into(binding.storyImg)*/

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