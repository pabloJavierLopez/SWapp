package com.cylit.swapp.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import com.cylit.swapp.R

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_principal) as NavHostFragment?
            ?: return

        val navController = host.navController

        appBarConfiguration = AppBarConfiguration(navController.graph)

        setupActionBar(navController, appBarConfiguration)

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(findNavController(R.id.nav_host_principal))
                || super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_principal).navigateUp(appBarConfiguration)
    }

    private fun setupActionBar(
        navController: NavController,
        appBarConfig: AppBarConfiguration,
    ) {
        setupActionBarWithNavController(navController, appBarConfig)
    }

}