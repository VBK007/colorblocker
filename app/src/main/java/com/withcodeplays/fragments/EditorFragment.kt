package com.withcodeplays.fragments

import android.Manifest
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.google.android.material.snackbar.Snackbar
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.withcodeplays.R
import com.withcodeplays.databinding.LayoutForEditorBinding
import com.withcodeplays.enuming.FilterAverageStatus
import com.withcodeplays.ext.toast
import com.withcodeplays.viewmodels.MainActivityUiModel
import ja.burhanrashid52.photoeditor.PhotoEditor


class EditorFragment : Fragment() {
    private val vm: MainActivityUiModel by activityViewModels()
    private var callTheDashBoardApiWithDate: ((normalMove: String) -> Unit)? = null
    private var callTheNumberBasedApiWithDate: ((normalMove: Int) -> Unit)? = null
    fun openPremium(callTheDashBoardApiWithDate: ((normalMove: String) -> Unit)? = null) {
        this.callTheDashBoardApiWithDate = callTheDashBoardApiWithDate
    }
    lateinit var photoEditor: PhotoEditor

    var permissionArrays = arrayOf<String>(
        Manifest.permission.CAMERA,
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE
    )
    lateinit var editorBinding: LayoutForEditorBinding

    fun openFullScreenAdd(callTheNumberBasedApiWithDate: ((normalMove: Int) -> Unit)? = null) {
        this.callTheNumberBasedApiWithDate = callTheNumberBasedApiWithDate
    }

    val PICK_IMAGES = 1002
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        editorBinding =
            DataBindingUtil.inflate(inflater, R.layout.layout_for_editor, container, false)
        return editorBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editorBinding.apply {
          photoEditor=  PhotoEditor.Builder(photoEditorView.context, photoEditorView)
                .setPinchTextScalable(true)
                .setClipSourceImage(true)
                .build().apply {
                    setBrushDrawingMode(true)
                }
            photoEditor.setBrushDrawingMode(true)
            actions = FilterAverageStatus.NoData
            //addImage click listener
            addImageLayout.setOnClickListener {
              getImagesFromlocalStorage()
            }
        }
    }

    private fun requestPermission() {
        editorBinding.apply {
            vm.apply {
              /*  Dexter.withContext(addImageLayout.context).withPermissions(
                    Manifest.permission.CAMERA,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                )
                    .withListener(object : MultiplePermissionsListener {
                        override fun onPermissionsChecked(multiplePermissionsReport: MultiplePermissionsReport) {
                            if (multiplePermissionsReport.areAllPermissionsGranted()) {
                               //call the Image list to load
                                getImagesFromlocalStorage()
                            }
                            // check for permanent denial of any permission
                            if (multiplePermissionsReport.isAnyPermissionPermanentlyDenied) {
                                // permission is denied permanently, we will show user a dialog message.
                                showSettingsDialog();
                            }
                        }

                        override fun onPermissionRationaleShouldBeShown(
                            p0: MutableList<PermissionRequest>?,
                            p1: PermissionToken?
                        ) {
                           p1?.continuePermissionRequest()
                        }
                    })

*/
                when {
                    ContextCompat.checkSelfPermission(addImageLayout.context, Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                            PackageManager.PERMISSION_GRANTED -> {
                        getImagesFromlocalStorage()
                    }
                    shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS) -> {
                        Snackbar.make(
                            topLayouts,
                            "The user denied the notifications ):",
                            Snackbar.LENGTH_LONG
                        )
                            .setAction("Settings") {
                                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                val uri: Uri =
                                    Uri.fromParts("com.withcodeplays", addImageLayout.context.packageName, null)
                                intent.data = uri
                                startActivity(intent)
                            }
                            .show()
                    }
                    else -> {
                      requestPermissionLauncher.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    }
                }

            }
        }
    }

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            // Permission is granted. Continue the action or workflow in your
            // app.
           getImagesFromlocalStorage()
        } else {
            toast("Please Enable permission to continue...")
        }
    }

    private fun getImagesFromlocalStorage() {
        editorBinding.apply {
            val intent  = Intent(MediaStore.ACTION_PICK_IMAGES)
            startActivityForResult(intent,PICK_IMAGES)
        }
    }

    private fun showSettingsDialog() {
     editorBinding.apply {
         val builder = AlertDialog.Builder(editorBinding.addImageLayout.context)
         builder.setTitle("Need Permissions")
         builder.setMessage("This app needs permission to use this feature. You can grant them in app settings.")
         builder.setPositiveButton("GOTO SETTINGS") { dialog, which ->
             dialog.cancel()
             val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
             val uri: Uri = Uri.fromParts("package", editorBinding.addImageLayout.context.packageName,
                 null)
             intent.data = uri
             startActivityForResult(intent, 101)
         }
         builder.setNegativeButton("Cancel") { dialog, which ->
             dialog.cancel()
         }
         builder.show()
     }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==PICK_IMAGES && data!=null)
        {
            editorBinding.apply {
                actions= FilterAverageStatus.ShowData
                Glide.with(addImageLayout.context)
                    .asBitmap()
                    .load(data.data)
                    .into(object : CustomTarget<Bitmap>(){
                        override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                            photoEditor.addImage(resource)
                        }
                        override fun onLoadCleared(placeholder: Drawable?) {
                            // this is called when imageView is cleared on lifecycle call or for
                            // some other reason.
                            // if you are referencing the bitmap somewhere else too other than this imageView
                            // clear it here as you can no longer have the bitmap
                        }
                    })

            }
        }
    }



}