package com.dacha.taskmanager1

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.dacha.taskmanager1.data.local.PrefName
import com.dacha.taskmanager1.data.local.PrefOnBoarding
import com.dacha.taskmanager1.databinding.ActivityMainBinding
import com.dacha.taskmanager1.databinding.FragmentProfileBinding

class MainActivity : AppCompatActivity() {
    private lateinit var prefName: PrefName
    private lateinit var prefOnBoard : PrefOnBoarding
    private lateinit var binding: ActivityMainBinding
    private lateinit var binding_: FragmentProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding_ = FragmentProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navView: BottomNavigationView = binding.navView
        prefOnBoard = PrefOnBoarding(this)
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        if (!prefOnBoard.isonBoardingShow()){
            navController.navigate(R.id.onBoardinfFragment)
        }
        if (!prefName.isNameShow()){
            binding_.etName.text.toString()
            binding_.etAge.text.toString().toInt()
        }
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.taskFragment
            )
        )

        val arrayList = arrayListOf(
            R.id.navigation_home,
            R.id.navigation_dashboard,
            R.id.navigation_notifications
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        navController.removeOnDestinationChangedListener { controller, destination, arguments ->
        navView.isInvisible = arrayList.contains(destination.id)
            if(destination.id == R.id.onBoardinfFragment){
                supportActionBar?.hide()
            }else supportActionBar?.show()

        }

}

}