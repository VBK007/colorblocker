package com.withcodeplays.fragments

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.withcodeplays.R
import com.withcodeplays.databinding.HomeFragmentDashboardBinding
import com.withcodeplays.enuming.FilterAverageStatus
import com.withcodeplays.ext.toast
import com.withcodeplays.models.HomeFragmentDataModels
import com.withcodeplays.recyleradapter.HomeFragmentRecyelerAdapter
import com.withcodeplays.viewmodels.BaseViewModel
import com.withcodeplays.viewmodels.MainActivityUiModel
import com.withcodeplays.viewmodels.ViewmodelDatamodels
import timber.log.Timber


class HomeFragment : Fragment() {
    lateinit var binding: HomeFragmentDashboardBinding
    private val vm: MainActivityUiModel by activityViewModels()
    private var callTheDashBoardApiWithDate: ((normalMove: String) -> Unit)? = null
    private var callTheNumberBasedApiWithDate: ((normalMove: Int) -> Unit)? = null
    fun openPremium(callTheDashBoardApiWithDate: ((normalMove: String) -> Unit)? = null) {
        this.callTheDashBoardApiWithDate = callTheDashBoardApiWithDate
    }

    fun openFullScreenAdd(callTheNumberBasedApiWithDate: ((normalMove: Int) -> Unit)? = null) {
        this.callTheNumberBasedApiWithDate = callTheNumberBasedApiWithDate
    }

    var permissionArrays = arrayOf<String>(
        Manifest.permission.CAMERA,
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE
    )
    var REQUEST_CODE = 101

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.home_fragment_dashboard, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            checkTheCondition()
            setObserver()
            btnRetry.setOnClickListener {
                //toast("Hello")
                checkTheCondition()
            }

        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE) {
            for (i in grantResults.indices) {
                val permission = permissions[i]
                if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                    binding.apply {
                        actions = FilterAverageStatus.NoData
                    }
                } else {
                    setUi()
                }
            }
        }
    }

    fun setRecylerData(localDataSets: ArrayList<ViewmodelDatamodels>) {
        binding.apply {
            vm.apply {
                mainRecyler.adapter = HomeFragmentRecyelerAdapter(localDataSets)
            }
        }
    }

    private fun setUi() {
        binding.apply {
            vm.apply {

            }
        }
    }

    private fun checkTheCondition() {
        vm.apply {
            binding.apply {
                showImagesFromLocalStorage()
               /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(permissionArrays, REQUEST_CODE);
                } else {
                    showImagesFromLocalStorage()
                }*/
            }
        }
    }

    private fun setObserver() {
        binding.apply {
            vm.apply {
                loader.observe(viewLifecycleOwner)
                {
                    when (it) {
                        BaseViewModel.SHOW -> {
                            actions = FilterAverageStatus.Loader
                        }
                        BaseViewModel.DISMISS -> {

                        }
                    }
                }

                setUI.observe(viewLifecycleOwner)
                {
                    when (it) {
                        MainActivityUiModel.IMAGE_TAKEN_SUCCESS -> {
                            actions = FilterAverageStatus.ShowData
                            liveDataFromViewModelMainActivity.value?.let { its ->
                                Timber.d("Size of data ${its.size}")
                                if (its.isNotEmpty()) setRecylerData(its) else actions = FilterAverageStatus.NoData
                            }
                        }

                        MainActivityUiModel.IMAGE_TAKEN_FAILURE -> {
                            actions = FilterAverageStatus.NoData
                        }
                    }
                }


            }
        }
    }

}