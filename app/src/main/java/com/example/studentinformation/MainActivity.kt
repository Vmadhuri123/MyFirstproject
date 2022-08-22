package com.example.studentinformation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.studentinformation.AppDatabase.Companion.getDatabase
import com.example.studentinformation.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var appdb:AppDatabase
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        appdb=getDatabase(this@MainActivity)
        binding.btnRg.setOnClickListener {
            writeData()
        }
        binding.btnDe.setOnClickListener {
            GlobalScope.launch {
                appdb.studentDao().deleteAll()
            }
        }

    }
    private fun writeData(){
        val firstname=binding.etFname.text.toString()
        val lastname=binding.etLname.text.toString()
        val email=binding.etEmail.text.toString()
        val password=binding.etPw.text.toString()

        val admin=binding.rbAd.isChecked



        if(firstname.isNotEmpty()&&lastname.isNotEmpty()&&email.isNotEmpty()&& password.isNotEmpty()) {
            val student=User(null,firstname,lastname,email,password,admin)
            GlobalScope.launch (Dispatchers.IO){
                appdb.studentDao().insert(student)
            }
          binding.etFname.text.clear()
            binding.etLname.text.clear()
            binding.etEmail.text.clear()
            binding.etPw.text.clear()
            binding.rg.clearCheck()






        }else Toast.makeText(this, "please enter data", Toast.LENGTH_SHORT).show()
    }
}
