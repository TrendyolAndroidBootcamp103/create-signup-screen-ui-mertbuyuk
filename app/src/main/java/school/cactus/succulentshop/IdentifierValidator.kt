package com.example.succulentshop

class IdentifierValidator : Validator {
    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.email_cannot_be_empty
        field.length < 5 -> R.string.identifier_is_too_short
        else -> null

    }

    override fun signupValidate(field: String) = when {
        field.isEmpty() -> R.string.email_required
        field.length < 5 || field.length > 50 -> R.string.invalid_email

        else -> {
            if (field.contains("@") && field.contains(".")) {
                null
            } else {
                R.string.invalid_email
            }
        }

    }


}
