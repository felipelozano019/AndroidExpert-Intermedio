package com.felipelozano.horoscopoapp.ui.home.ui.horoscope.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.felipelozano.horoscopoapp.R
import com.felipelozano.horoscopoapp.ui.home.domain.model.HoroscopeInfo

class HoroscopeAdapter(
    private var horoscopeList: List<HoroscopeInfo> = emptyList(),
    private val onHoroscopeClick: (HoroscopeInfo) -> Unit //funcion lambda
) :
    RecyclerView.Adapter<HoroscopeViewHolder>() {

    fun updateData(newHoroscopeList: List<HoroscopeInfo>) {
        horoscopeList = newHoroscopeList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        return HoroscopeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_horoscope, parent, false)
        )
    }

    override fun getItemCount(): Int = horoscopeList.size

    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        holder.render(horoscopeList[position], onHoroscopeClick)
    }
}