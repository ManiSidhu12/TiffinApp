package com.tiffin.app

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.google.firebase.database.*
import com.tiffin.app.com.adapter.app.LocationAdapter
import com.tiffin.app.com.model.app.Users
import kotlinx.android.synthetic.main.location_listing.*
import kotlin.collections.ArrayList

class LocationListing : Activity(){
    var databseRefrence : DatabaseReference?= null
    var listLocations = ArrayList<Users>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.location_listing)

        databseRefrence = FirebaseDatabase.getInstance().getReference("users")

        val query = databseRefrence!!.orderByChild("sector").equalTo("60")
        Log.e("query",query.toString())
        recycler_location.layoutManager = LinearLayoutManager(this@LocationListing)

    }

    override fun onStart() {
        super.onStart()
        databseRefrence!!.addValueEventListener(object  : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                listLocations.clear()
                for(userShot : DataSnapshot in p0.children){
                    Log.e("loc",userShot.value.toString())
                    var user :Users  = userShot.getValue<Users>(Users::class.java)!!
                    listLocations.add(user)

                }
                recycler_location.adapter = LocationAdapter(this@LocationListing,listLocations)


            }

        })
    }
}