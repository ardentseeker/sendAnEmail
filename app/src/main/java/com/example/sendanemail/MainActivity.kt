package com.example.sendanemail

import android.annotation.SuppressLint
import android.content.Intent
import android.content.IntentSender
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.sendanemail.databinding.ActivityMainBinding
import javax.security.auth.Subject

class MainActivity : AppCompatActivity() {


    lateinit var mainBinding: ActivityMainBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        mainBinding.button.setOnClickListener {

            val sender = mainBinding.editTextTextPersonName.text.toString()
            val subject = mainBinding.editTextTextPersonName2.text.toString()
            val message = mainBinding.editTextTextMultiLine.text.toString()

            sendEmail(sender,subject,message)

        }


    }

    fun sendEmail(userEmail:String,userSub:String,userMsg:String){

        val emailAdresses = arrayOf(userEmail)
        /*
        val emailIntent = Intent(Intent.ACTION_SENDTO)
        emailIntent.data = Uri.parse("mailto:")

         */

        val emailIntent = Intent(Intent.ACTION_SEND)
        emailIntent.type =  "text/plain"   //"*/*"
        emailIntent.putExtra(Intent.EXTRA_EMAIL,emailAdresses)
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,userSub)
        emailIntent.putExtra(Intent.EXTRA_TEXT,userMsg)

        if (emailIntent.resolveActivity(packageManager) != null){
            startActivity(Intent.createChooser(emailIntent,"choose an app"))
        }


    }
}