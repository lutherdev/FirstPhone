package com.example.firstphone

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstphone.databinding.ActivityLoginBinding
import com.example.firstphone.databinding.ActivityReviewInfoBinding
import org.w3c.dom.Text

class ReviewInfo : AppCompatActivity() {
//    lateinit var btnBack: Button
//    lateinit var tvFirstName: TextView
//    lateinit var tvMiddleName: TextView
//    lateinit var tvLastName: TextView
//    lateinit var tvEmail: TextView

    private lateinit var binding: ActivityReviewInfoBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityReviewInfoBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_review_info)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        tvFirstName = findViewById<TextView>(R.id.tvFirstName)
//        tvMiddleName = findViewById<TextView>(R.id.tvMiddleName)
//        tvLastName = findViewById<TextView>(R.id.tvLastName)
//        tvEmail = findViewById<TextView>(R.id.tvEmail)

        val bundle = intent.extras

        binding.tvFirstName.text = bundle?.getString("firstName")
        binding.tvMiddleName.text = bundle?.getString("middleName")
        binding.tvLastName.text = bundle?.getString("lastName")
        binding.tvEmail.text = bundle?.getString("email")


        //btnBack = findViewById<Button>(R.id.btnSignBack)
        binding.btnSignBack.setOnClickListener{
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
    }
}