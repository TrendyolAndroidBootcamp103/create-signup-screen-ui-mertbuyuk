package com.example.succulentshop

import school.cactus.succulentshop.R

class PasswordValidator : Validator {
    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.password_cannot_be_empty
        else -> null
    }

    override fun signupValidate(field: String): Int? {
        val a: Boolean = field.any { it.isLowerCase() }
        val d: Boolean = field.any { it.isUpperCase() }
        val c: Boolean = field.all { it.isLetterOrDigit() }
        val b: Int
        if (field.isEmpty()) {

            b = R.string.password_cannot_be_empty
        } else if (field.length < 2) {
            b = R.string.password_short

        } else if (field.length > 20) {
            b = R.string.password_long

        } else if ((a == false || d == false) || c == true) {
            b = R.string.password_rules
        } else {
            return null
        }
        return b

    }


}