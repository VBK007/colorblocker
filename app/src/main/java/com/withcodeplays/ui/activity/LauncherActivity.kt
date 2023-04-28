package com.withcodeplays.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.withcodeplays.MainActivity
import com.withcodeplays.R
import com.withcodeplays.databinding.OnboardingBinding
import com.withcodeplays.photoediting.EditImageActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LauncherActivity:AppCompatActivity() {
    lateinit var  onboardingBinding: OnboardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onboardingBinding = DataBindingUtil.setContentView(this, R.layout.onboarding)
        onboardingBinding.apply {
           frame2.setOnClickListener {
               onboardingBinding.apply {
                   val intent = Intent(this@LauncherActivity, EditImageActivity::class.java)
                   intent.apply {
                       flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                       flags  = Intent.FLAG_ACTIVITY_NEW_TASK
                   }
                   startActivity(intent)
                   finish()
               }
           }
        }
    }
}