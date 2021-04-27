package com.example.succulentshop

import school.cactus.succulentshop.R

class UsernameValidator : Validator {

    override fun validate(field: String): Int? {
        return null
    }

    override fun signupValidate(field: String): Int? {

        val a: String = field.replace("_", "")
        val c: Boolean = a.all { it.isLetterOrDigit() }
        val d: Boolean = a.any { it.isUpperCase() }
        val b: Int
        if (field.isEmpty()) {
            b = R.string.required_username
        } else if (field.length < 2) {
            b = R.string.username_short

        } else if (field.length > 20) {
            b = R.string.username_long
        } else if (c == false || d) {
            b = R.string.username_rules
        } else {
            return null
        }
        return b

    }
}