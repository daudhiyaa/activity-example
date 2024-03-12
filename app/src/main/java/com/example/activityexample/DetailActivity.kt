package com.example.activityexample

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activityexample.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRAS_KEY_IMG_PROFILE = "EXTRAS_KEY_IMG_PROFILE"
        const val EXTRAS_KEY_NAME = "EXTRAS_KEY_NAME"
        const val EXTRAS_KEY_ROLE = "EXTRAS_KEY_ROLE"

        fun startActivity(context: Context, imgResDrawable: Int?, name: String?, role: String?) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXTRAS_KEY_IMG_PROFILE, imgResDrawable)
            intent.putExtra(EXTRAS_KEY_NAME, name)
            intent.putExtra(EXTRAS_KEY_ROLE, role)
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
        val imgResDrawable = intent.extras?.getInt(EXTRAS_KEY_IMG_PROFILE)
        val textName = intent.extras?.getString(EXTRAS_KEY_NAME)
        val textRole = intent.extras?.getString(EXTRAS_KEY_ROLE)
        setProfileImage(imgResDrawable)
        setProfileData(textName, textRole)
    }

    private fun setProfileImage(imgResDrawable: Int?) {
        imgResDrawable?.let { binding.ivProfile.setImageResource(it) }
    }

    private fun setProfileData(textName: String?, textRole: String?) {
        textName?.let { binding.tvName.text = it }
        textRole?.let { binding.tvRole.text = it }
    }
}