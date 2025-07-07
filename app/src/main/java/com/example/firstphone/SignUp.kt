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
import com.example.firstphone.databinding.ActivityLoginBinding
import com.example.firstphone.databinding.ActivitySignUpBinding

class SignUp : AppCompatActivity() {
//    lateinit var btnLoginBack: Button
//    lateinit var btnSignUp: Button
//    lateinit var etFirstName: EditText
//    lateinit var etMiddleName: EditText
//    lateinit var etLastName: EditText
//    lateinit var etEmail: EditText
//    lateinit var etPassword: EditText
//    lateinit var etConfirmPass: EditText

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        enableEdgeToEdge()

        //setContentView(R.layout.activity_sign_up)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //btnLoginBack = findViewById<Button>(R.id.btnLoginBack)
        //btnSignUp = findViewById<Button>(R.id.btnSignupProceed)

//        etFirstName = findViewById<EditText>(R.id.etFirstName)
//        etMiddleName = findViewById<EditText>(R.id.etMiddleName)
//        etLastName = findViewById<EditText>(R.id.etLastname)
//        etEmail = findViewById<EditText>(R.id.etEmail)
//        etPassword = findViewById<EditText>(R.id.etPassword)
//        etConfirmPass = findViewById<EditText>(R.id.etConfirmPass)



        binding.btnLoginBack.setOnClickListener{
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
        binding.btnSignupProceed.setOnClickListener{

            val bundle = Bundle()
            bundle.putString("firstName", binding.etFirstName.text.toString())
            bundle.putString("middleName", binding.etMiddleName.text.toString())
            bundle.putString("lastName", binding.etLastname.text.toString())
            bundle.putString("email", binding.etEmail.text.toString())
            bundle.putString("password", binding.etPassword.text.toString())
            if (binding.etPassword.text.toString().equals(binding.etConfirmPass.text.toString())){
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