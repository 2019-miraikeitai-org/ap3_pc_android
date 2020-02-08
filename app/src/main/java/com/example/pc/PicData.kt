package com.example.pc

import android.graphics.Bitmap
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize



@Parcelize
data class PicData(
    val pic : Bitmap
): Parcelable