package com.example.activityexample.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    val name: String,
    val role: String,
    val desc: String,
    @DrawableRes
    val imgProfile: Int
) : Parcelable
