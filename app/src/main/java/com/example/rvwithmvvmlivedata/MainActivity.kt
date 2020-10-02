package com.example.rvwithmvvmlivedata

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val sharedPrefFile = "kotlinsharedpreference"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile,
            Context.MODE_PRIVATE)
        buttonSave.setOnClickListener {
            var name: String? = editTextName.text.toString()
            var pass: Int? = Integer.parseInt(editTextPass.text.toString())
            var email:String? = editTextEmail.text.toString()


            val editor:SharedPreferences.Editor =  sharedPreferences.edit()
            editor.putString("name",name)
            editor.putInt("password",pass!!)
            editor.putString("email",email)
            editor.apply()
            editor.commit()
            Toast.makeText(this,"Thanks",Toast.LENGTH_SHORT).show()
        }

        buttonView.setOnClickListener {
            val sharedName = sharedPreferences.getString("name","defName")
            val sharedPass = sharedPreferences.getInt("password",0)
            val sharedEmail = sharedPreferences.getString("email","defEmail")
            if(sharedName.equals("defName") && sharedPass.equals(0) && sharedEmail.equals("defEmail")){
                textViewName.text = "default Name: ${sharedName}".toString()
                textViewPass.text = "default Name: ${sharedPass}".toString()
                textViewEmail.text = "default Name: ${sharedEmail}".toString()
            } else{
                textViewName.text = sharedName.toString()
                textViewPass.text = sharedPass.toString()
                textViewEmail.text = sharedEmail.toString()
            }
        }

        buttonClear.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
        }

    }
}