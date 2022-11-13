package com.example.massignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.Toolbar
import com.example.massignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var mytoolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {

        binding =ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        mytoolbar = findViewById(R.id.appbar)
        mytoolbar.title = "Table"
        setSupportActionBar(mytoolbar)



        val userNum: EditText = binding.etNum
        val showTable: Button = binding.btnTable

        showTable.setOnClickListener {

            val number = userNum.text.toString()
            val num = number.toInt()

            val intent = Intent(this,tableActivity::class.java)

            intent.putExtra("number",num)

            startActivity(intent)
        }

    }
}