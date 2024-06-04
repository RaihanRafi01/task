package com.example.practise.ui.list

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.practise.databinding.ActivityListBinding
import com.example.practise.model.repository.ItemRepository
import kotlinx.coroutines.launch

class ListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListBinding
    private lateinit var itemAdapter: ItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recylerView.layoutManager = LinearLayoutManager(this)

        fetchStories()
        binding.btnback.setOnClickListener {
            onBackPressed()
        }
    }
    private fun fetchStories() {

        val itemRepository = ItemRepository()
        lifecycleScope.launch {
            try {
                val items = itemRepository.getItems()
                val all = items.data.host_daily.all
                    binding.txtTop1.text = items.data.host_daily.top3[0].first_name
                    binding.txtTop2.text = items.data.host_daily.top3[1].first_name
                    binding.txtTop3.text = items.data.host_daily.top3[2].first_name
                    binding.txtPoint1.text = items.data.host_daily.top3[0].giftcoin.toString()
                    binding.txtPoint2.text = items.data.host_daily.top3[1].giftcoin.toString()
                    binding.txtPoint3.text = items.data.host_daily.top3[2].giftcoin.toString()

                Glide.with(binding.root.context)
                    .load(items.data.host_daily.top3[1].profile_pic)
                    .into(binding.imgTop2)
                Glide.with(binding.root.context)
                    .load(items.data.host_daily.top3[2].profile_pic)
                    .into(binding.imgTop3)
                Glide.with(binding.root.context)
                    .load(items.data.host_daily.top3[0].profile_pic)
                    .into(binding.imgTop1)

                itemAdapter = ItemAdapter(all)
                binding.recylerView.adapter = itemAdapter
                Log.e("TAG", "bind: $items")
            } catch (e: Exception) {
                Log.e("TAG", "error: $e")
            }
        }
    }
}