package com.mif50.madarsoftkotlin.ui.main.item

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mif50.madarsoftkotlin.R
import com.mif50.madarsoftkotlin.data.local.db.location.LocationAddress
import com.mikepenz.fastadapter.items.AbstractItem
import kotlinx.android.synthetic.main.item_location.view.*

class ItemLocation : AbstractItem<ItemLocation, ItemLocation.ItemLocationViewHolder>() {
    lateinit var location: LocationAddress

    fun withItem(location: LocationAddress): ItemLocation {
        this.location = location
        return this
    }

    override fun getType(): Int {
        return R.id.item_location
    }

    override fun getViewHolder(v: View): ItemLocationViewHolder {
        return ItemLocationViewHolder(v)
    }

    override fun getLayoutRes(): Int {
        return R.layout.item_location
    }

    override fun bindView(holder: ItemLocationViewHolder, payloads: MutableList<Any>) {
        super.bindView(holder, payloads)
        holder.itemView.let {
            it.latTv.text = String.format(it.context.getString(R.string.lat),location.lat)
            it.lngTv.text = String.format(it.context.getString(R.string.lng),location.lng)
        }
    }

    class ItemLocationViewHolder(v: View) : RecyclerView.ViewHolder(v)

}