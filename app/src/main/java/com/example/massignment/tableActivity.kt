package com.example.massignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.massignment.databinding.ActivityTableBinding
import java.util.*

class tableActivity : AppCompatActivity(),TextToSpeech.OnInitListener {

    lateinit var binding: ActivityTableBinding
    private lateinit var mytoolbar: Toolbar

    private var tts:TextToSpeech? = null
    private var sButton:ImageButton?= null
    private var txtView:TextView ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTableBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mytoolbar = findViewById(R.id.appbar)
        mytoolbar.title = "Speak Table"
        setSupportActionBar(mytoolbar)


        //speak table
        sButton = binding.btnSpeak
        txtView = binding.tvSpeakTable
        sButton!!.isEnabled = false
        tts = TextToSpeech(this,this)

        sButton!!.setOnClickListener{
            speakTable()
        }



        //For showing code table
        val bundle:Bundle? = intent.extras

        val number = bundle?.getInt("number")

        val num: TextView = binding.tvSpeakTable

        var str: String = ""

        if (number != null) {
            if(number > 1000){

                num.text = ("Enter Value Less than 1000")

            }
            else{
                for (n in 1..10){

                    str += "$number * $n = ${number*n}\n"
                }
                num.text = str
            }
        }


        if (number != null) {

        }
        else{
            Toast.makeText(this,"Enter number",Toast.LENGTH_LONG).show()
        }

        //Showing table code till here

    }


    //for speaking
    private fun speakTable() {
        tts!!.speak(txtView?.text.toString(),TextToSpeech.QUEUE_FLUSH,null,"")
        tts!!.setSpeechRate(0.5F)

    }

    //intializing
    override fun onInit(status: Int) {
        if(status == TextToSpeech.SUCCESS){

            val result = tts!!.setLanguage(Locale.US)

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                Toast.makeText(this,"Enter number",Toast.LENGTH_SHORT).show()
            }
            else{
                sButton!!.isEnabled = true
            }
        }else{
            Toast.makeText(this,"Table speaking initialized",Toast.LENGTH_SHORT).show()
        }
    }

    //on back press destroy
    public override fun onDestroy() {
        // Shutdown TTS
        if (tts != null) {
            tts!!.stop()
            tts!!.shutdown()
        }
        super.onDestroy()
    }

}