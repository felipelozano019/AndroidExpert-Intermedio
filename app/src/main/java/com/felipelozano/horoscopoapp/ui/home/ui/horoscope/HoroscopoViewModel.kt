package com.felipelozano.horoscopoapp.ui.home.ui.horoscope

import androidx.lifecycle.ViewModel
import com.felipelozano.horoscopoapp.ui.home.data.provider.HoroscopeProvider
import com.felipelozano.horoscopoapp.ui.home.domain.model.HoroscopeInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopoViewModel @Inject constructor(horoscopeProvider: HoroscopeProvider) :
    ViewModel() {

    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())
    val horoscope = _horoscope

    init {
        _horoscope.value = horoscopeProvider.getHorosopeList()

    }

}