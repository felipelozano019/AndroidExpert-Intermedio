package com.felipelozano.horoscopoapp.ui.home.ui.detailed

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.navArgs
import com.felipelozano.horoscopoapp.R
import com.felipelozano.horoscopoapp.databinding.ActivityHoroscopeDetailedBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HoroscopeDetailedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHoroscopeDetailedBinding
    private val HoroscopeDetailedViewModel: HoroscopeDetailedViewModel by viewModels()

    private val args:HoroscopeDetailedActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopeDetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}