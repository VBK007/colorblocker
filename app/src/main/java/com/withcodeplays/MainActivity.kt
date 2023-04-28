package com.withcodeplays

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.navigation.NavigationBarView
import com.withcodeplays.databinding.ActivityMainBinding
import com.withcodeplays.fragments.EditorFragment
import com.withcodeplays.fragments.HomeFragment
import com.withcodeplays.fragments.ProfileFragment
import com.withcodeplays.viewmodels.MainActivityUiModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {
    lateinit var mainBinding: ActivityMainBinding
    val mainViewModels by viewModels<MainActivityUiModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainBinding.apply {
            setUi()
            bottomeMenu.setOnItemSelectedListener(this@MainActivity)
            bottomeMenu.selectedItemId = R.id.filter
            setObserver()
        }
    }

    private fun setUi() {
        mainBinding.apply {
            mainViewModels.apply {
                //showImagesFromLocalStorage()

            }
        }
    }

    private fun setObserver() {
        mainBinding.apply {
            mainViewModels.apply {

            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        mainBinding.apply {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment, fragment, "CURR_FRAGMENT")
                .commit()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.dashBoard -> {
                calltheDashBoardFragment()
            }
            R.id.filter -> {
                calltheEditBoardFragment()
            }
            R.id.home -> {
                calltheProfileBoardFragment()
            }
        }

        return false
    }


    private fun calltheDashBoardFragment() {
        mainBinding.apply {
            CURRENT_TAG = R.id.dashBoard
            val fragment = HomeFragment()
            fragment.openPremium { its -> }
            fragment.openFullScreenAdd { its -> }
            loadFragment(fragment)
        }
    }


    private fun calltheEditBoardFragment() {
        mainBinding.apply {
            CURRENT_TAG = R.id.filter
            val fragment = EditorFragment()
            fragment.openPremium { its -> }
            fragment.openFullScreenAdd { its -> }
            loadFragment(fragment)
        }
    }


    private fun calltheProfileBoardFragment() {
        mainBinding.apply {
            CURRENT_TAG = R.id.home
            val fragment = ProfileFragment()
            fragment.openPremium { its -> }
            fragment.openFullScreenAdd { its -> }
            loadFragment(fragment)
        }
    }


    companion object {
        var CURRENT_TAG = 0
    }
}