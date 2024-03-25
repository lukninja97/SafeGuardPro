package com.lukninja.safeguardpro.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.lukninja.safeguardpro.R
import com.lukninja.safeguardpro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!

    val homeScreens = listOf(R.id.funcionariosFragment, R.id.episFragment)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)

        val navHostFragment = supportFragmentManager.findFragmentById(binding.fragmentContainerView.id) as NavHostFragment
        val navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
        binding.bottomNavigation.setupWithNavController(navController)

        setContentView(binding.root)

        //TODO Logica para nao mostrar a seta na toolbar
//        navController.addOnDestinationChangedListener { controller,destination,_ ->
//            controller.currentDestination?.let {
//                if ( it.id in homeScreens) {
//                    destination.parent?.setStartDestination(it.id)
//                    destination.label = "test"
//                }
//            }
//        }
    }
}