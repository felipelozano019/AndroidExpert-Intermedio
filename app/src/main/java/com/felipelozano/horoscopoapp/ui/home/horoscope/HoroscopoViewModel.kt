package com.felipelozano.horoscopoapp.ui.home.horoscope

import androidx.lifecycle.ViewModel
import com.felipelozano.horoscopoapp.domain.HoroscopoInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopoViewModel @Inject constructor(): ViewModel(){

    private var _horoscopo = MutableStateFlow<List<HoroscopoInfo>>(emptyList())
    val horoscopo: StateFlow<List<HoroscopoInfo>> = _horoscopo

    init {
        _horoscopo.value = listOf(
            HoroscopoInfo.Aries,
            HoroscopoInfo.Taurus,
            HoroscopoInfo.Gemini,
            HoroscopoInfo.Cancer,
            HoroscopoInfo.Leo,
            HoroscopoInfo.Virgo,
            HoroscopoInfo.Libra,
            HoroscopoInfo.Scorpio,
            HoroscopoInfo.Sagittarius,
            HoroscopoInfo.Capricorn,
            HoroscopoInfo.Aquarius,
            HoroscopoInfo.Pisces
        )
    }

    fun getHoroscopo(){
        

    }

}