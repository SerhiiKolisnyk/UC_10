package com.softserve.sk.uc

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class RegexTest {
    @Test
    fun checkValidDecimalCases() {
        val decimalSentences = listOf(
            "1Aa@",
            "Aa1@",
            "Aa@1",
            "Aa@1111",
            "Aa-21"
        )
        decimalSentences.forEach {
            it.shouldBeValid()
        }
    }

    @Test
    fun checkInvalidDecimalCases() {
        "Aa@".shouldBeInvalid()
    }

    @Test
    fun checkValidLowercase() {
        val data = listOf(
            "a_D1@",
            "Da1@",
            "D1@a",
            "D1aa@",
            "Aa-21"
        )
        data.forEach {
            it.shouldBeValid()
        }
    }

    @Test
    fun checkLowercaseIsAbsent() {
        val data = listOf(
            "AAA1@",
            "@@@DDDD??"
        )
        data.forEach {
            it.shouldBeInvalid()
        }
    }

    @Test
    fun checkValidUppercase() {
        val data = listOf(
            "DD1@a",
            "Da1@a",
            "@D@3a",
            "@@@@@dsds1D",
            "CodeSmells2@"
        )
        data.forEach {
            it.shouldBeValid(20u)
        }
    }

    @Test
    fun checkUppercaseIsAbsent() {
        val data = listOf(
            "aavdfw2@",
            "dse2###"
        )
        data.forEach {
            it.shouldBeInvalid()
        }
    }


    @Test
    fun checkLengthTest() {
        "HereIs@8".shouldBeValid(8u)

        "TooLongSentence1@".shouldBeInvalid(maxLength = 5u)
    }

    @Test
    fun emptyTest() {
        "".shouldBeInvalid(8u)
        "".shouldBeInvalid(0u)
    }

    @Test
    fun whitespacesShouldBeForbidden() {
        val data = listOf(
            "Hi 2@nd",
            "(?=.*[a-Z] [)",
            "Hello 2 and @",
            "Hello@2  TAB",
            "Hello@2\rTAB2",
            "Hello@2\n new line",
            " Hello@SpaceIs1",
            "Hello1@SpaceIsLast ",
        )

        data.forEach {
            it.shouldBeInvalid()
        }
    }

    @Test
    fun shouldContainSpecialCharacter() {
        val specificCharacters = """!"#{'$'}%&'()*+,-./:;<=>?@[\]^_`{|}~"""

        specificCharacters.forEach {
            val sentence = "CharIs${it}And66"
            sentence.shouldBeValid(30u)
        }
    }

    private fun String.shouldBeValid(maxLength: UInt = 10u) {
        val isValid = this.isValid(maxLength)
        assertTrue(this, isValid)
    }

    private fun String.shouldBeInvalid(maxLength: UInt = 10u) {
        val isValid = this.isValid(maxLength)
        assertFalse(this, isValid)
    }
}