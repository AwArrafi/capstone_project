package com.capstoneproject.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MenuItem(
    val imageResId: Int,
    val title: String,
    val description: String
) : Parcelable
