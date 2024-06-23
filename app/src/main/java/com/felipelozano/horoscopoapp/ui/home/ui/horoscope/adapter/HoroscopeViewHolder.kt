package com.felipelozano.horoscopoapp.ui.home.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.felipelozano.horoscopoapp.databinding.ItemHoroscopeBinding
import com.felipelozano.horoscopoapp.ui.home.domain.model.HoroscopeInfo

class HoroscopeViewHolder (view: View): RecyclerView.ViewHolder(view){

    private val binding = ItemHoroscopeBinding.bind(view)

    fun render(horoscopeInfo: HoroscopeInfo, onHoroscopeClick: (HoroscopeInfo) -> Unit){
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvHoroscope.text = binding.tvHoroscope.context.getString(horoscopeInfo.name)

        binding.parent.setOnClickListener{
           // onHoroscopeClick(horoscopeInfo)
            startRotation(binding.ivHoroscope, newLambda = {onHoroscopeClick(horoscopeInfo)})
        }



    }
    private fun startRotation(view: View, newLambda:() -> Unit){
        view.animate().apply {
            duration = 250
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withStartAction { newLambda() }
            start()
        }
    }
}