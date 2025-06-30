package com.example.firstphone

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUp : AppCompatActivity() {
    lateinit var btnLoginBack: Button
    lateinit var btnSignUp: Button
    lateinit var etFirstName: EditText
    lateinit var etMiddleName: EditText
    lateinit var etLastName: EditText
    lateinit var etEmail: EditText
    lateinit var etPassword: EditText
    lateinit var etConfirmPass: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnLoginBack = findViewById<Button>(R.id.btnLoginBack)
        btnSignUp = findViewById<Button>(R.id.btnSignupProceed)

        etFirstName = findViewById<EditText>(R.id.etFirstName)
        etMiddleName = findViewById<EditText>(R.id.etMiddleName)
        etLastName = findViewById<EditText>(R.id.etLastname)
        etEmail = findViewById<EditText>(R.id.etEmail)
        etPassword = findViewById<EditText>(R.id.etPassword)
        etConfirmPass = findViewById<EditText>(R.id.etConfirmPass)



        btnLoginBack.setOnClickListener{
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
        btnSignUp.setOnClickListener{


            val bundle = Bundle()
            bundle.putString("firstName", etFirstName.text.toString())
            bundle.putString("middleName", etMiddleName.text.toString())
            bundle.putString("lastName", etLastName.text.toString())
            bundle.putString("email", etEmail.text.toString())
            bundle.putString("password", etPassword.text.toString())
            if (etPassword.text.toString().equals(etConfirmPass.text.toString())){
                val intent = Intent(this, ReviewInfo::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }
            else {
                Toast.makeText(this, "Password does not match, please retype your pass", Toast.LENGTH_LONG).show()
            }

        }
    }
}