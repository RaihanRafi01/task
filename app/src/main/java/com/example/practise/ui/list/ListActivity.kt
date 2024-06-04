package com.example.practise.ui.list

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
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

    }
    private fun fetchStories() {

        val itemRepository = ItemRepository()
        lifecycleScope.launch {
            try {
                val items = itemRepository.getItems()
                val all = items.data.host_daily.all
                itemAdapter = ItemAdapter(all)
                binding.recylerView.adapter = itemAdapter
                Log.e("TAG", "bind: $items")
            } catch (e: Exception) {
                Log.e("TAG", "error: $e")
            }
        }
    }
}