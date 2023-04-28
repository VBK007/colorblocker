package com.withcodeplays.viewmodels

import android.content.ContentUris
import android.provider.MediaStore
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.withcodeplays.familytracker.di.PreferenceManager
import com.withcodeplays.models.HomeFragmentDataModels
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainActivityUiModel @Inject constructor(val preferenceManager: PreferenceManager) :
    BaseViewModel() {

    val liveDataFromViewModelMainActivity: MutableLiveData<ArrayList<ViewmodelDatamodels>> =
        MutableLiveData()

    fun showImagesFromLocalStorage() {
        viewModelScope.launch(Dispatchers.IO)
        {
            showLoader()
            try {
                val imageList = queryImageStorage()
                val arraylistOfMainSteam = ArrayList<ViewmodelDatamodels>()
                getRecent10Images(imageList).let {
                    if (it.isNotEmpty()) {
                        arraylistOfMainSteam.add(
                            ViewmodelDatamodels(
                                listOfRecent10Images = it,
                                itemType = 0
                            )
                        )
                    }
                }
                getWhatsApp10Images(imageList).let {
                    if (it.isNotEmpty()) {
                        arraylistOfMainSteam.add(
                            ViewmodelDatamodels(
                                listOfWhatsApp20Images = it,
                                itemType = 0
                            )
                        )
                    }
                }

                getRandom20Images(imageList).let {
                    if (it.isNotEmpty()) {
                        arraylistOfMainSteam.add(
                            ViewmodelDatamodels(
                                listOfRandom20Images = it,
                                itemType = 0
                            )
                        )
                    }
                }


               /* imageList.let {
                    if (it.isNotEmpty()) {
                        arraylistOfMainSteam.add(
                            ViewmodelDatamodels(
                                listofImagesFromLocalUri = it,
                                itemType = 1
                            )
                        )
                    }
                }*/
                Timber.d("Data coming sucess ")
                liveDataFromViewModelMainActivity.postValue(arraylistOfMainSteam)
                setUi(IMAGE_TAKEN_SUCCESS)
            } catch (exception: java.lang.Exception) {
                hideLoader()
                setUi(IMAGE_TAKEN_FAILURE)
                Timber.e(
                    "Exception in getting images from local storrage \n ${exception.message}",
                    exception
                )
            }
        }
    }


    private fun getRandom20Images(imageList: ArrayList<HomeFragmentDataModels>): ArrayList<HomeFragmentDataModels> {
        val listofImages = ArrayList<HomeFragmentDataModels>()
        try {
            listofImages.addAll(
                imageList.asSequence().shuffled()
                    .take(if (imageList.size < 20) imageList.size else 20).toList()
            )
        } catch (exception: java.lang.Exception) {
            Timber.d("Exception while processing data ${exception.message}", exception)
        }
        return listofImages
    }

    private fun getWhatsApp10Images(imageList: ArrayList<HomeFragmentDataModels>): ArrayList<HomeFragmentDataModels> {
        val listofImages = ArrayList<HomeFragmentDataModels>()
        try {
            listofImages.addAll(
                imageList.toList().subList(0, if (imageList.size < 10) imageList.size else 10)
            )
        } catch (exception: java.lang.Exception) {
            Timber.d("Exception while processing data ${exception.message}", exception)
        }
        return listofImages
    }

    private fun getRecent10Images(imageList: ArrayList<HomeFragmentDataModels>): ArrayList<HomeFragmentDataModels> {
        val listofImages = ArrayList<HomeFragmentDataModels>()
        try {
            listofImages.addAll(
                imageList.toList().subList(0, if (imageList.size < 10) imageList.size else 10)
            )
        } catch (exception: java.lang.Exception) {
            Timber.d("Exception while processing data ${exception.message}", exception)
        }
        return listofImages
    }

    private fun queryImageStorage(): ArrayList<HomeFragmentDataModels> {
        val listofImages = ArrayList<HomeFragmentDataModels>()
        val imageProjection = arrayOf(
            MediaStore.Images.Media.DISPLAY_NAME,
            MediaStore.Images.Media.SIZE,
            MediaStore.Images.Media.DATE_TAKEN,
            MediaStore.Images.Media._ID
        )
        val imageSortOrder = "${MediaStore.Images.Media.DATE_TAKEN} DESC"
        val cursor = preferenceManager.context.applicationContext.contentResolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            imageProjection,
            null,
            null,
            imageSortOrder
        )
        cursor.use {
            it?.let {
                val idColumn = it.getColumnIndexOrThrow(MediaStore.Images.Media._ID)
                val nameColumn = it.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME)
                val sizeColumn = it.getColumnIndexOrThrow(MediaStore.Images.Media.SIZE)
                val dateColumn = it.getColumnIndexOrThrow(MediaStore.Images.Media.DATE_TAKEN)

                while (it.moveToNext()) {
                    val id = it.getLong(idColumn)
                    val name = it.getString(nameColumn)
                    val size = it.getString(sizeColumn)
                    val date = it.getString(dateColumn)

                    val contentUri = ContentUris.withAppendedId(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                        id
                    )

                    listofImages.add(
                        HomeFragmentDataModels(
                            uriForImage = contentUri.toString(),
                            createdAt = date,
                            fileName = name,
                            fileSet = size,
                            fileId = id
                        )
                    )
                    // add the URI to the list
                    // generate the thumbnail
                    /*  val thumbnail = (this as Context).contentResolver.loadThumbnail(contentUri, Size(480, 480), null)
  */
                }
            } ?: kotlin.run {
                Timber.e("Cursor is null!")
            }
        }

        return listofImages
    }

    companion object {
        const val IMAGE_TAKEN_SUCCESS = 1001
        const val IMAGE_TAKEN_FAILURE = 1002
    }

}