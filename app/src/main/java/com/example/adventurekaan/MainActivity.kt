package com.example.adventurekaan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.adventurekaan.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

private lateinit var binding: ActivityMainBinding

private lateinit var navController: NavController
private lateinit var appBarConfiguration: AppBarConfiguration

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    appBarConfiguration = AppBarConfiguration(
        setOf(
            R.id.cultureFragment,
            R.id.videosFragment,
            R.id.zonasFragment,

        )
    )

    val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
    navController = navHostFragment.findNavController()

    //Toolbar
    setSupportActionBar(binding.toolbar)
    setupActionBarWithNavController(navController, appBarConfiguration)

    //Bottom Navigation
    binding.bottomNavigationView.setupWithNavController(navController)

}
    override fun onSupportNavigateUp(): Boolean {
        return super.onSupportNavigateUp()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.top_menu, menu)
    return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
    return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }
}