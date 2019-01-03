package com.tiffin.app.com.adapter.app

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tiffin.app.R
import com.tiffin.app.UserListing
import com.tiffin.app.com.model.app.Users
import kotlinx.android.synthetic.main.location_adapter.view.*

class LocationAdapter(var ctx: Context,var listLocations: ArrayList<Users>) : RecyclerView.Adapter<LocationAdapter.ViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        var v = LayoutInflater.from(ctx).inflate(R.layout.location_adapter,p0,false)
        return ViewHolder(v)


    }

    override fun getItemCount(): Int {
        return listLocations.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.txtSector.text = listLocations[p1].sector

        p0.itemView.setOnClickListener {
            ctx.startActivity(Intent(ctx,UserListing::class.java).putExtra("sector",listLocations[p1].sector))
        }
    }

    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
var txtSector = itemView.sectortxt
    }
}
