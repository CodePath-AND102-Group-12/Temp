package com.example.unnamedgroup12project.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.unnamedgroup12project.R

class LogInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btn = findViewById<Button>(R.id.loginButton)
        btn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            this.startActivity(intent)
        }

        //TODO: Relocate "list market" button to better place
        val tempButton = findViewById<Button>(R.id.addMarketBtn)
        tempButton.setOnClickListener {
            val intent = Intent(this, AddMarketActivity::class.java)
            this.startActivity(intent)
        }

    }
}
