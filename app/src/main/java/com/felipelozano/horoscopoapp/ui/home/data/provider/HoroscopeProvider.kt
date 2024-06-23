package com.felipelozano.horoscopoapp.ui.home.data.provider

import com.felipelozano.horoscopoapp.ui.home.domain.model.HoroscopeInfo
import com.felipelozano.horoscopoapp.ui.home.domain.model.HoroscopeInfo.*
import javax.inject.Inject

class HoroscopeProvider @Inject constructor(){
    fun getHorosopeList(): List<HoroscopeInfo> {
        return listOf(
            Taurus,
            Gemini,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Scorpio,
            Sagittarius,
            Capricorn,
            Aquarius,
            Pisces
        )
    }
}