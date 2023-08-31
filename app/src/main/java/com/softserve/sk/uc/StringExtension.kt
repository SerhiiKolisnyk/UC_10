package com.softserve.sk.uc

private const val PREFERRED_LIST = """!"#{'$'}%&'()*+,-./:;<=>?@[\]^_`{|}~"""

fun String.isValid(maxLength: UInt): Boolean {
    val lowerCase = "(?=.*[a-z])"
    val uppercase = "(?=.*[A-Z])"
    val digit = "(?=.*[0-9])"
    val allowedLength = ".{0,${maxLength}}"
    val specialCharacter = "(?=.*[${Regex.escape(PREFERRED_LIST)}])"
    val forbidWhitespaces = "[^\\s]"

    val pattern = """
       ^$lowerCase$uppercase$digit$specialCharacter$forbidWhitespaces$allowedLength$
    """.trimIndent()

    return this.matches(Regex(pattern))
}
