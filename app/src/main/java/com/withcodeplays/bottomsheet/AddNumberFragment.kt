package com.withcodeplays.bottomsheet

import android.os.Bundle
import android.text.method.DigitsKeyListener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.withcodeplays.R
import com.withcodeplays.databinding.BottomAddPhoneNumberBinding
import com.withcodeplays.ext.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNumberFragment : BottomSheetDialogFragment() {
    lateinit var binding: BottomAddPhoneNumberBinding
    private var addNumber: ((String, String,String) -> Unit)? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.bottom_add_phone_number,
            null,
            false
        )
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.showProgress = true
        dialog?.apply {
            setCanceledOnTouchOutside(false)
        }
        binding.apply {
            btnOk.setOnClickListener {
                if (etNickName.text.toString().isEmpty() || etNickName.text.toString().trim().isEmpty()) {
                    toast("Please Enter the File Name")
                    return@setOnClickListener
                }
                addNumber?.invoke(etNickName.text.toString().trim(),"","")
                dismiss()
            }
            btnCancel.setOnClickListener {
                dismiss()
            }
        }
    }

    private fun addNumber(name: String, phone: String,countryCode:String) {
        addNumber?.invoke(name, phone,countryCode)
    }

    fun setAddNumberListener(function: (String, String,String) -> Unit) {
        addNumber = function
    }
}