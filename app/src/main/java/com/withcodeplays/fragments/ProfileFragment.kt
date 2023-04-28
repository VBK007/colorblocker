package com.withcodeplays.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.withcodeplays.R
import com.withcodeplays.databinding.LayoutForProfileBinding
import com.withcodeplays.viewmodels.MainActivityUiModel

class ProfileFragment:Fragment() {
    private val vm: MainActivityUiModel by activityViewModels()
    private var callTheDashBoardApiWithDate: ((normalMove: String) -> Unit)? = null
    private var callTheNumberBasedApiWithDate: ((normalMove: Int) -> Unit)? = null
    fun openPremium(callTheDashBoardApiWithDate: ((normalMove: String) -> Unit)? = null) {
        this.callTheDashBoardApiWithDate = callTheDashBoardApiWithDate
    }

    fun openFullScreenAdd(callTheNumberBasedApiWithDate: ((normalMove: Int) -> Unit)? = null) {
        this.callTheNumberBasedApiWithDate = callTheNumberBasedApiWithDate
    }
    lateinit var binding:LayoutForProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.layout_for_profile,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}