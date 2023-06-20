package br.com.hyudin.multiple_counter.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.hyudin.multiple_counter.databinding.ActivityMultiplecounterBinding

class MultipleCounterActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMultiplecounterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMultiplecounterBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}