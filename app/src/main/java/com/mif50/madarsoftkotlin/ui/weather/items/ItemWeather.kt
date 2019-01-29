package com.mif50.madarsoftkotlin.ui.weather.items

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mif50.madarsoftkotlin.R
import com.mif50.madarsoftkotlin.data.remote.api.model.ListData
import com.mikepenz.fastadapter.items.AbstractItem
import kotlinx.android.synthetic.main.item_weather.view.*

class ItemWeather : AbstractItem<ItemWeather, ItemWeather.ItemWeatherViewHolder>() {
    lateinit var data: ListData
    fun withItem(data: ListData): ItemWeather {
        this.data = data
        return this
    }

    override fun getType(): Int {
        return R.id.item_weather
    }

    override fun getViewHolder(v: View): ItemWeatherViewHolder {
        return ItemWeatherViewHolder(v)
    }

    override fun getLayoutRes(): Int {
        return R.layout.item_weather
    }

    override fun bindView(holder: ItemWeatherViewHolder, payloads: MutableList<Any>) {
        super.bindView(holder, payloads)
        holder.itemView.let {

            it.pressureTv.text = String.format("pressure :  %s", data.mPressure)
            it.humidityTv.text = String.format("humidity :  %s", data.mHumidity)
            it.descriptionTv.text = String.format("description :  %s", data.mWeather[0].mDescription)
            it.speedTv.text = String.format("speed :  %s", data.mSpeed)
            it.degTv.text = String.format("deg :  %s", data.mDeg)
        }
    }

    class ItemWeatherViewHolder(v: View) : RecyclerView.ViewHolder(v)
}