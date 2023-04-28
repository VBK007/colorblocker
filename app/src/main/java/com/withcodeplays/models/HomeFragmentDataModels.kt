package com.withcodeplays.models

import androidx.annotation.Keep
import java.io.File

@Keep
data class HomeFragmentDataModels(
    var uriForImage: String? = null,
    var createdAt: String? = null,
    var fileId: Long? = null,
    var fileName: String? = null,
    var fileSet: String? = null
) : java.io.Serializable