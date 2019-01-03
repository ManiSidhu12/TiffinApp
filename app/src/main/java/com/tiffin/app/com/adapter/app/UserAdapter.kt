package com.tiffin.app.com.adapter.app

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.database.DatabaseReference
import com.tiffin.app.R
import com.tiffin.app.com.model.app.Users
import kotlinx.android.synthetic.main.users_adapter.view.*



class UserAdapter (var ctx: Context, var listUser: ArrayList<Users>,var databseRefrence: DatabaseReference,var listKeys : ArrayList<String>) :  RecyclerView.Adapter<UserAdapter.ViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        var v = LayoutInflater.from(ctx).inflate(R.layout.users_adapter,p0,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return  listUser.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.txtName.text = listUser[p1].userName
        p0.txtPhn.text = listUser[p1].phoneNo

        if(listUser[p1].lunch.equals("")){
            p0.imgLunch.setImageResource(R.drawable.unslct)
        }
        else{
            p0.imgLunch.setImageResource(R.drawable.sel)

        }
         if(listUser[p1].dinner.equals("")){
            p0.imgDinner.setImageResource(R.drawable.unslct)

        }
        else{
             p0.imgDinner.setImageResource(R.drawable.sel)

         }
        /*else if(listUser[p1].mealType.equals("both")){
            p0.imgDinner.setImageResource(R.drawable.sel)
            p0.imgLunch.setImageResource(R.drawable.sel)

        }*/

        p0.layDinner.setOnClickListener {
            if(listUser[p1].dinner.equals("")){
                databseRefrence.child(listKeys[p1]).child("dinner").setValue("dinner")
               // p0.imgDinner.setImageResource(R.drawable.sel)


            }
            else{
                databseRefrence.child(listKeys[p1]).child("dinner").setValue("")
               // p0.imgDinner.setImageResource(R.drawable.unslct)

            }

        }
        p0.layLunch.setOnClickListener {
            if (listUser[p1].lunch.equals("")) {
                databseRefrence.child(listKeys[p1]).child("lunch").setValue("lunch")
              //  p0.imgLunch.setImageResource(R.drawable.sel)


            } else {
                databseRefrence.child(listKeys[p1]).child("lunch").setValue("")
               // p0.imgLunch.setImageResource(R.drawable.unslct)


            }
        }
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var txtName = itemView.nametxt
        var txtPhn = itemView.phntxt
        var layLunch = itemView.lay_lunch
        var layDinner = itemView.lay_dinner
        var imgLunch = itemView.img_lunch
        var imgDinner = itemView.img_dinner
    }
}