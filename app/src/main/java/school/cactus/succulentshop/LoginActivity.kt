package com.example.succulentshop

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import school.cactus.succulentshop.R
import school.cactus.succulentshop.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    private val identifierValidator = IdentifierValidator()
    private val passwordValidator = PasswordValidator()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {
            LoginButton.setOnClickListener {
                outlinedTextFieldemail.validate()
                outlinedTextFieldpassword.validate()
            }
            CreateAccountButton.setOnClickListener {
                navigateToOther()
            }
        }

        supportActionBar?.title = getString(R.string.log_in)

    }

    private fun Int.resolveAsString() = getString(this)//bu method ile sourceda ki keylerin valuelerine eerişiyoruz
    //bu this gelen integeri temsil ediyor

    private fun TextInputLayout.validator() = when (this) {//burda ki thiste gelen inputlayout tipi o an ki
        binding.outlinedTextFieldemail -> identifierValidator//görünüm buysa bu tarzında düşün
        binding.outlinedTextFieldpassword -> passwordValidator
        else -> null
    }

    private fun TextInputLayout.validate() {
        val errorMessage = validator()!!.validate(editText!!.text.toString())
        error = errorMessage?.resolveAsString()
        isErrorEnabled = errorMessage != null // boş değilse hata mesajı o hatalr kısmı gözüksün ve dursun
    }

    private fun navigateToOther() {
        val intent = Intent(this, SignupActivity::class.java)
        startActivity(intent)
    }


}

