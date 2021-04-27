package com.example.succulentshop

interface Validator {
    fun validate(field: String): Int? // int dönme sebebi mesajlara sourcedan ulaşıcaz sourceda da mesajlar id : int ile tutuluyor

    fun signupValidate(field: String): Int?
}