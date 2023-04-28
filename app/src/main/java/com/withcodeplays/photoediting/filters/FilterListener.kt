package com.withcodeplays.photoediting.filters

import ja.burhanrashid52.photoeditor.PhotoFilter

interface FilterListener {
    fun onFilterSelected(photoFilter: PhotoFilter)
}