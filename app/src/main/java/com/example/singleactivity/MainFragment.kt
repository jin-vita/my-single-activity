package com.example.singleactivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.singleactivity.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val navController by lazy {
        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.nav_fragment) as NavHostFragment
        navHostFragment.navController
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBack.setOnClickListener { findNavController().navigateUp() }
        setUpBottomNavigation()
    }

    private fun setUpBottomNavigation() {
        binding.bottomNavView.setupWithNavController(navController)
        binding.bottomNavView.setOnItemReselectedListener {
            if (binding.bottomNavView.selectedItemId == it.itemId) {
                when (it.itemId) {
                    R.id.homeFragment -> println("Home 또 누름")
                    R.id.liveFragment -> println("Live 또 누름")
                    R.id.profileFragment -> println("Profile 또 누름")
                }
                return@setOnItemReselectedListener
            }
        }
    }

}