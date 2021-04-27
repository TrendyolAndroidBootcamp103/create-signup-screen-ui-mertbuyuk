package com.example.succulentshop

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.succulentshop.databinding.ActivitySignupBinding
import com.google.android.material.textfield.TextInputLayout

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding

    private val identifierValidator = IdentifierValidator()

    private val usernameValidator = UsernameValidator()

    private val passwordnameValidator = PasswordValidator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = getString(R.string.sign_up)

        binding.apply {
            SignupButton.setOnClickListener {
                outlinedTextFieldSignUpemail.signupValidate()
                outlinedTextFieldSignUpusername.signupValidate()
                outlinedTextFieldSignuppassword.signupValidate()
            }

            AlreadyHaveAccountButton.setOnClickListener {
                navigateToOther()
            }


        }


    }

    private fun Int.resolveAsString() = getString(this)

    private fun TextInputLayout.validator() = when (this) {
        binding.outlinedTextFieldSignUpemail -> identifierValidator
        binding.outlinedTextFieldSignUpusername -> usernameValidator
        binding.outlinedTextFieldSignuppassword -> passwordnameValidator
        else -> null
    }//

    private fun TextInputLayout.signupValidate() {

        val errorMessage = validator()!!.signupValidate(editText!!.text.toString())
        error = errorMessage?.resolveAsString()
        isErrorEnabled = errorMessage != null

    }


    private fun navigateToOther() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}