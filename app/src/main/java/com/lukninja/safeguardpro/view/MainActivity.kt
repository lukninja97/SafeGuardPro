package com.lukninja.safeguardpro.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.lukninja.safeguardpro.R
import com.lukninja.safeguardpro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!

    private val homeScreens = listOf(
        R.id.homeFragment,
        R.id.homeSupervisorFragment,
//        R.id.funcionariosFragment,
//        R.id.episFragment,
//        R.id.entregaFragment,
    )

    private val secondaryScreens = listOf(
        R.id.loginFragment,
        R.id.funcionarioFragment,
        R.id.epiFragment,
        R.id.epiDetailFragment
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(binding.fragmentContainerView.id) as NavHostFragment
        val navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
        binding.bottomNavigation.setupWithNavController(navController)


        //TODO Logica para nao mostrar a seta na toolbar
        navController.addOnDestinationChangedListener { controller,destination,_ ->
            controller.currentDestination?.let {
                if (it.id == R.id.loginFragment) {
                    binding.toolbar.visibility = View.GONE
                } else {
                    binding.toolbar.visibility = View.VISIBLE
                }

                if ( it.id in homeScreens) {
                    actionBar?.setDisplayHomeAsUpEnabled(false)
                    destination.parent?.setStartDestination(it.id)
                }

                if (it.id in secondaryScreens) {
                    binding.bottomNavigation.visibility = View.GONE
                } else {
                    binding.bottomNavigation.visibility = View.VISIBLE
                }

                if (it.id == R.id.homeFragment) {
                    binding.bottomNavigation.menu.clear()
                    binding.bottomNavigation.inflateMenu(R.menu.bottom_menu_funcionario)
                } else if (it.id == R.id.homeSupervisorFragment) {
                    binding.bottomNavigation.menu.clear()
                    binding.bottomNavigation.inflateMenu(R.menu.bottom_menu)
                }
            }
        }
    }
}