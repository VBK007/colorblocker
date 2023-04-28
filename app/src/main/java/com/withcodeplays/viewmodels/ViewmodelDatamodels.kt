package com.withcodeplays.viewmodels

import androidx.annotation.Keep
import com.withcodeplays.models.HomeFragmentDataModels

@Keep
data class ViewmodelDatamodels(
   var listOfRecent10Images:ArrayList<HomeFragmentDataModels>?=null,
   var listOfRandom20Images:ArrayList<HomeFragmentDataModels>?=null,
   var listOfWhatsApp20Images:ArrayList<HomeFragmentDataModels>?=null,
   var listofImagesFromLocalUri:ArrayList<HomeFragmentDataModels>?=null,
   var itemType:Int=0
):java.io.Serializable