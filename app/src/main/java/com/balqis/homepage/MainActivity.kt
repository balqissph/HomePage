package com.balqis.homepage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val editTextEmail = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val editTextPassword = findViewById<EditText>(R.id.editTextTextPassword)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)

        buttonLogin.setOnClickListener {
            val emailInput = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()

            if (emailInput.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Email dan Password harus diisi!", Toast.LENGTH_SHORT).show()
            } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
                Toast.makeText(this, "Format email tidak valid!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Login Berhasil!", Toast.LENGTH_SHORT).show()

                val logTag = "Email"
                if (logTag == "Email") {
                    Log.d(logTag, emailInput)
                } else {
                    Log.d(logTag, "")
                }

                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("email", emailInput)
                startActivity(intent)
                finish()
            }
        }
    }
}
