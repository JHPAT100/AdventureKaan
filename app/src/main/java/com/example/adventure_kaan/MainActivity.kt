package com.example.adventure_kaan

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adventure_kaan.databinding.ActivityMainBinding
import com.example.adventure_kaan.ui.culture.CultureFragment
import com.example.adventure_kaan.ui.videos.VideosFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navView: BottomNavigationView = binding.navView


        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        //Metodo que carga la interaccion con el menu de navegaciones
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                //Cargamos las navegaciones que estan referenciadas al directorio navigation/fragment
                R.id.navigation_culture,
                R.id.navigation_archaeological_zones,
                R.id.navigation_videos
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


        navView.setOnItemReselectedListener{
            when(it.itemId) {

                R.id.navigation_culture -> findNavController(R.id.nav_host_fragment_activity_main).navigate(R.id.navigation_culture)
                R.id.navigation_archaeological_zones-> findNavController(R.id.nav_host_fragment_activity_main).navigate(R.id.navigation_archaeological_zones)
                R.id.navigation_videos -> findNavController(R.id.nav_host_fragment_activity_main).navigate(R.id.navigation_videos)
            }

        }


    }

    /*
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }

    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host_fragment_activity_main,fragment)
        fragmentTransaction.commit()
    }

     */

}

        /*
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(CultureFragment())
        val navView: BottomNavigationView = binding.navView
        binding.navView.setOnItemSelectedListener {


            when(it.itemId){

                R.id.navigation_culture -> replaceFragment(CultureFragment())
                R.id.navigation_archaeological_zones-> replaceFragment(VideosFragment())
                R.id.navigation_videos -> replaceFragment(VideosFragment())

                else ->{

                }

            }
            true
        }


    }

    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host_fragment_activity_main,fragment)
        fragmentTransaction.commit()
    }
    */

        /*
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main)

        setupBottomNavMenu(navController)


    }

    private fun setupBottomNavMenu(navController: NavController) {
        val navView: BottomNavigationView = binding.navView
        navView?.let {
            NavigationUI.setupWithNavController(it, navController)
        }
    }
    }
*/


