package br.com.hyudin.multiple_counter.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import br.com.hyudin.multiple_counter.R
import br.com.hyudin.multiple_counter.databinding.ActivityMultiplecounterBinding

class MultipleCounterActivity: AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMultiplecounterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMultiplecounterBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        val navController = findNavController(R.id.nav_host_fragment_container_multiplecounter)
        appBarConfiguration = AppBarConfiguration(navController.graph)
    }
}