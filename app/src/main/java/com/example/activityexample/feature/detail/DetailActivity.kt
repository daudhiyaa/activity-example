package com.example.activityexample.feature.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activityexample.databinding.ActivityDetailBinding
import com.example.activityexample.feature.home.HomeFragment
import com.example.activityexample.model.Person

class DetailActivity : AppCompatActivity() {

    companion object {
        private const val EXTRAS_DETAIL_DATA = "EXTRAS_DETAIL_DATA"

        fun startActivity(context: Context, person: Person) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXTRAS_DETAIL_DATA, person)
            context.startActivity(intent)
        }
    }

    private val binding: ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getIntentData()
    }

    private fun getIntentData() {
        intent.extras?.getParcelable<Person>(EXTRAS_DETAIL_DATA)?.let {
            setProfileData(it)
        }
    }

    private fun setProfileData(person: Person) {
        binding.ivProfile.setImageResource(person.imgProfile)
        binding.tvName.text = person.name
        binding.tvRole.text = person.role
        binding.tvDescription.text = person.desc
    }
}