package com.seytkalievm.tinkoffjunlab.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.seytkalievm.tinkoffjunlab.R
import com.seytkalievm.tinkoffjunlab.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavMenu.setupWithNavController(navController)
        binding.bottomNavMenu.setOnItemSelectedListener {
            NavigationUI.onNavDestinationSelected(it, navController)
            it.isChecked = true
            true
        }

        val mainScreens = setOf(R.id.popularFilmsFragment, R.id.favouriteFilmsFragment)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            val height = binding.bottomNavMenu.height.toFloat()

            when (destination.id) {
                in mainScreens -> {
                    binding.bottomNavMenu.animate().translationY(0f).duration = 300
                    binding.bottomNavMenu.visibility = View.VISIBLE
                }
                else -> {
                    binding.bottomNavMenu.animate().translationY(height).duration = 300
                    binding.bottomNavMenu.visibility = View.GONE
                }
            }
        }
    }
}