package com.example.aviatickets.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aviatickets.R
import com.example.aviatickets.databinding.ActivityMainBinding
import com.example.aviatickets.fragment.OfferListFragment
import com.example.aviatickets.model.network.ApiClient
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val apiClient = ApiClient.getInstance().create(ApiClient::class.java)
        GlobalScope.launch {
            val result = apiClient.getFlight()
            if (result != null)
                log.d("Assan", result.body().toString())
        }

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container_view, OfferListFragment.newInstance())
            .commit()

    }
}