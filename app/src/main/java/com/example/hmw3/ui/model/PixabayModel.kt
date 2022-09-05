package com.example.hmw3.ui.model

import android.graphics.ColorSpace

data class PixabayModel(var total:Int, var totalHits:Int, var hits:List<ImageModel>)

data class ImageModel(val largeImageURL:String)
