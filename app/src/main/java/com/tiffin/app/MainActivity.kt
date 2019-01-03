package com.tiffin.app

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.tiffin.app.com.model.app.Users
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {
 var firebaseInstance : FirebaseDatabase ?= null
    var databseRefrence : DatabaseReference ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        firebaseInstance = FirebaseDatabase.getInstance()
        databseRefrence = FirebaseDatabase.getInstance().getReference("users")

       work()
    }

    fun work(){
       btn_add.setOnClickListener {
           if(validate()){
              var id : String = databseRefrence!!.push().key!!

               var user = Users(edt_name.text.toString(),id,edt_location.text.toString(),edt_sector.text.toString(),edt_tiffins.text.toString(),edt_phn.text.toString(),"","","")
              databseRefrence!!.child(id).setValue(user)

               Toast.makeText(this@MainActivity,"User Added...",Toast.LENGTH_SHORT).show()
               startActivity(Intent(this@MainActivity,LocationListing::class.java))

           }
       }
    }
    private fun validate() : Boolean{
        if(edt_name.text.toString().isEmpty()){
            Toast.makeText(this@MainActivity,"Please Enter Name..",Toast.LENGTH_SHORT).show()
            return false
        }
        else  if(edt_location.text.toString().isEmpty()){
            Toast.makeText(this@MainActivity,"Please Enter Location..",Toast.LENGTH_SHORT).show()
            return false
        }
       else if(edt_sector.text.toString().isEmpty()){
            Toast.makeText(this@MainActivity,"Please Enter Sector..",Toast.LENGTH_SHORT).show()
            return false
        }
        else  if(edt_tiffins.text.toString().isEmpty()){
            Toast.makeText(this@MainActivity,"Please Enter No. of Tiffins. ..",Toast.LENGTH_SHORT).show()
            return false
        }
        else  if(edt_phn.text.toString().isEmpty()){
            Toast.makeText(this@MainActivity,"Please Enter Phone No..",Toast.LENGTH_SHORT).show()
            return false
        }
        else  if(edt_phn.text.toString().length < 10 || edt_phn.text.toString().length > 10){
            Toast.makeText(this@MainActivity,"Phone No. should be of 10 digits ..",Toast.LENGTH_SHORT).show()
            return false
        }
        else{
            return true
        }

    }

}
