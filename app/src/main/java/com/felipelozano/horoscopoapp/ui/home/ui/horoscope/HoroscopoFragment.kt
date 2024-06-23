package com.felipelozano.horoscopoapp.ui.home.ui.horoscope

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.felipelozano.horoscopoapp.databinding.FragmentHoroscopoBinding
import com.felipelozano.horoscopoapp.ui.home.domain.model.HoroscopeInfo
import com.felipelozano.horoscopoapp.ui.home.domain.model.HoroscopeInfo.*
import com.felipelozano.horoscopoapp.ui.home.domain.model.HoroscopeModel
import com.felipelozano.horoscopoapp.ui.home.ui.horoscope.adapter.HoroscopeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopoFragment : Fragment() {

    private val horoscopoViewModel by viewModels<HoroscopoViewModel>()
    private lateinit var horoscopeAdapter: HoroscopeAdapter

    private var _binding: FragmentHoroscopoBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initRV()
        initUIState()
    }


    private fun initUIState() {
        lifecycleScope.launch { //Coroutine Fragment
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopoViewModel.horoscope.collect {
                    //Cambios en el estado del horoscopo
                    horoscopeAdapter.updateData(it)
                }
            }

        }
    }

    private fun initRV() {
        horoscopeAdapter = HoroscopeAdapter(onHoroscopeClick = {

            val type = when (it) {
                Aquarius -> HoroscopeModel.AQUARIUS
                Aries -> HoroscopeModel.ARIES
                Cancer -> HoroscopeModel.CANCER
                Capricorn -> HoroscopeModel.CAPRICORN
                Gemini -> HoroscopeModel.GEMINI
                Leo -> HoroscopeModel.LEO
                Libra -> HoroscopeModel.LIBRA
                Pisces -> HoroscopeModel.PISCES
                Sagittarius -> HoroscopeModel.SAGITTARIUS
                Scorpio -> HoroscopeModel.SCORPIO
                Taurus -> HoroscopeModel.TAURUS
                Virgo -> HoroscopeModel.VIRGO
            }

            findNavController().navigate(
                HoroscopoFragmentDirections.actionHoroscopoFragmentToHoroscopeDetailedActivity(type)
            )
        })

        binding.rvHoroscope.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = horoscopeAdapter
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHoroscopoBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

}