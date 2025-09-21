package com.example.mygittests

import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.util.UUID

internal object UserHashGenerator {

    fun getPasswordHash(password: String): String {
        val uuid  = UUID.randomUUID()
        val input  = password + uuid.toString()

        val bytes = input.toByteArray(StandardCharsets.UTF_8)
        val messageDigest = MessageDigest.getInstance("MD5")
        val hashedBytes = messageDigest.digest(bytes)

        return bytesToHexString(hashedBytes)
    }

    private fun bytesToHexString(bytes: ByteArray): String {
        val stringBuilder = StringBuilder()
        for (byte in bytes) {
            stringBuilder.append(String.format("%02x", byte))
        }
        return stringBuilder.toString()
    }

}