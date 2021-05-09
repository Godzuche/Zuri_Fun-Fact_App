
package com.example.funfact

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.funfact.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private var binding: ActivityLoginBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        Toast.makeText(this, "Welcome back Godzuche!", Toast.LENGTH_LONG).show()
        login()
    }

    private fun login() {

        binding?.loginButton?.setOnClickListener {
            if(binding?.emailEditText?.text.toString().isEmpty() || binding?.passwordEditText?.text.toString().isEmpty()) {
                Toast.makeText(this, "Email or Password is not provided", Toast.LENGTH_LONG).show()
            } else {
                if(binding?.emailEditText?.text.toString().lowercase() == "godzuche@zuri.com" && binding?.passwordEditText?.text.toString() == "zuri222") {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Wrong Email or Password: Use Godzuche@zuri.com : Password = zuri222", Toast.LENGTH_LONG).show()
                }
            }
        }

        binding?.forgotPasswordButton?.setOnClickListener {
            if (binding?.emailEditText?.text.toString().lowercase() != "godzuche@zuri.com") {
                Toast.makeText(this, "Use Godzuche@zuri.com : Password = zuri222" , Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Password = zuri222", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}