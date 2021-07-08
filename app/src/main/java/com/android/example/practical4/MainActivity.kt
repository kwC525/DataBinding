package com.android.example.practical4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.android.example.practical4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var aPerson: Person = Person("ali", "123456", "ali@gmail.com", "123 Jalan ABC")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.personData = aPerson

        binding.btnUpdate.setOnClickListener(){
            aPerson.email ="xxx@gmail.com"
            aPerson.address = "123 Jalan ZXE"

            //binding.personData = aPerson //<<cannot do like this, but it work.
            binding.apply { invalidateAll() } //do like this

        }



        /*binding.txtName.text= aPerson.name
        binding.txtNRIC.text= aPerson.ic
        binding.txtEmail.text= aPerson.email
        binding.txtAddress.text= aPerson.address
        */

        /*
        val txtName: TextView = findViewById(R.id.txtName)
        val txtNRIC: TextView = findViewById(R.id.txtNRIC)
        val txtEmail: TextView = findViewById(R.id.txtEmail)
        val txtAddress: TextView = findViewById(R.id.txtAddress)
        */




    }


}