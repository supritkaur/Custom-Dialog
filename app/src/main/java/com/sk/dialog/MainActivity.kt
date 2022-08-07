package com.sk.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.icu.number.IntegerWidth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.sk.dialog.databinding.ActivityMainBinding
import com.sk.dialog.databinding.CustomdialogBinding

class MainActivity : AppCompatActivity() {
    lateinit var tv1: TextView
    lateinit var tv2: TextView
    lateinit var tv3: TextView
    lateinit var dialog: Dialog
    lateinit var Binding: CustomdialogBinding
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv1=findViewById(R.id.tv1)
        tv2=findViewById(R.id.tv2)
        tv3=findViewById(R.id.tv3)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Binding = CustomdialogBinding.inflate(layoutInflater)
        dialog = Dialog(this)
        dialog.setContentView(Binding.root)


        binding.btn1.setOnClickListener {
            Binding.et1.setText(binding.tv1.text.toString())
            Binding.et2.setText(binding.tv2.text.toString())
            if(Binding.rb1.isChecked) {
              binding.tv3.setText("Female")
            }else if(Binding.rb2.isChecked){
                binding.tv3.setText("Male")
            }
            else
            {
                Binding.rb3.isChecked
                Binding.et3.visibility =View.VISIBLE
                Binding.et3.setText(tv3.text.toString())
            }
            dialog.show()}

        Binding.rgGender.setOnCheckedChangeListener { radioGroup, id ->
            when (id) {
                R.id.rb3 -> {
                    Binding.et3.visibility = View.VISIBLE
                }
                else -> {
                    Binding.et3.visibility = View.INVISIBLE
                }
            }
        }

        Binding.btnUpdate.setOnClickListener {
            if (Binding.et1.text.isNullOrEmpty()) {
                Toast.makeText(this, "Enter Name", Toast.LENGTH_LONG).show()
                Binding.et1.requestFocus()
            } else if (Binding.et2.text.isNullOrEmpty()) {
                Toast.makeText(this, "Enter Address", Toast.LENGTH_LONG).show()
                Binding.et2.requestFocus()
            } else if ((Binding.rb3.isChecked) && (Binding.et3.text.isNullOrEmpty())) {
                Toast.makeText(this, "Enter Other Gender", Toast.LENGTH_LONG).show()
                Binding.et3.requestFocus()
            } else {
                binding.tv1.setText(Binding.et1.text.toString())
                binding.tv2.setText(Binding.et2.text.toString())
                if (Binding.rb3.isChecked) {
                    binding.tv3.setText(Binding.et3.text.toString())
                } else if (Binding.rb1.isChecked) {
                    binding.tv3.setText("Female")
                } else if (Binding.rb2.isChecked) {
                   binding.tv3.setText("Male")
                }
                dialog.dismiss()
            }
        }
    }
}




