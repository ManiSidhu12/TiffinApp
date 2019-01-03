package com.tiffin.app

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import com.google.firebase.database.*
import com.tiffin.app.com.adapter.app.UserAdapter
import com.tiffin.app.com.model.app.Users
import kotlinx.android.synthetic.main.user_listing.*
import java.util.*


class UserListing : Activity(){
    var databseRefrence : DatabaseReference?= null
    var listUser = ArrayList<Users>()
    var compare = ArrayList<Users>()
    var listKeys = ArrayList<String>()
    var listKeys1 = ArrayList<String>()
var sector :  String ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_listing)
        databseRefrence = FirebaseDatabase.getInstance().getReference("users")

        recycler_users.layoutManager = LinearLayoutManager(this@UserListing)
sector = intent.getStringExtra("sector")


        edt_srch.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
filter(edt_srch.text.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        })

    }

    //******* Implementing filter method to search text in list
    fun filter(text: String) {
        var text = text

        text = text.toLowerCase(Locale.getDefault())
        compare.clear()
        listKeys1.clear()

        if (text.length == 0) {
            compare.clear()
            listKeys1.clear()
            compare.addAll(listUser)
            listKeys1.addAll(listKeys)
        } else {

            compare.clear()
            listKeys1.clear()
            for (i in 0 until listUser.size) {
                if (listUser[i].userName.toLowerCase(Locale.getDefault()).contains(text)) {

                    compare.add(listUser[i])
                    listKeys1.add(listKeys[i])
                }

            }
        }
        recycler_users.adapter = UserAdapter(this@UserListing,compare,databseRefrence!!,listKeys1)

    }
    override fun onStart() {
        super.onStart()
        databseRefrence!!.orderByChild("sector").equalTo(sector).addListenerForSingleValueEvent(object  : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                listUser.clear()
                listKeys.clear()
                for(userShot : DataSnapshot in p0.children){
                    Log.e("key",userShot.key)
                    var user : Users = userShot.getValue<Users>(Users::class.java)!!
                    listUser.add(user)
                    listKeys.add(userShot.key.toString())

                }

                recycler_users.adapter = UserAdapter(this@UserListing,listUser,databseRefrence!!,listKeys)
            }

        })
    }
}