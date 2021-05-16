package com.example.funfact

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.funfact.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private var binding: ActivityDetailBinding? = null
    private var logo = 0
    private var name: String? = null
    private var detail: String? = null
    private var about: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        logo = intent.getIntExtra(FactAdapter.LOGO_EXTRAS, 0)
        name = intent.getStringExtra(FactAdapter.NAME_EXTRAS)
        detail = intent.getStringExtra(FactAdapter.FACT_EXTRAS)
        about = intent.getStringExtra(FactAdapter.ABOUT_EXTRAS)

        setupFactDetail()
    }

    private fun setupFactDetail() {
        binding?.detailLv?.text = detail
        binding?.logoLv?.setImageResource(logo)
        binding?.secondaryTextLv?.text = about
        title = name
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}