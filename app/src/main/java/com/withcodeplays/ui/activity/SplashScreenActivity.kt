package com.withcodeplays.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.withcodeplays.MainActivity
import com.withcodeplays.R
import com.withcodeplays.databinding.SplashBinding
import com.withcodeplays.familytracker.di.PreferenceManager
import com.withcodeplays.photoediting.EditImageActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import timber.log.Timber

@AndroidEntryPoint
class SplashScreenActivity : AppCompatActivity() {
    lateinit var splashBinding: SplashBinding
    val globalScope = CoroutineScope(Dispatchers.Main)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding = DataBindingUtil.setContentView(this, R.layout.splash)
        splashBinding.apply {
            PreferenceManager(this@SplashScreenActivity).apply {
                globalScope.launch {
                    delay(3000)
                    isUserFirstTime.let {
                        Timber.d("Is this first time $it")
                        if (it) {
                            movetoLauncherActivity()
                            isUserFirstTime = false
                        } else {
                            moveToMainActivity()
                        }
                    }

                }

            }
        }
    }

    private fun moveToMainActivity() {
        splashBinding.apply {
            val intent = Intent(this@SplashScreenActivity,EditImageActivity::class.java)
            intent.apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                flags  = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            startActivity(intent)
            finish()
        }
    }

    private fun movetoLauncherActivity() {
        splashBinding.apply {
            val intent = Intent(this@SplashScreenActivity,LauncherActivity::class.java)
            intent.apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                flags  = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            startActivity(intent)
            finish()
        }
    }





}