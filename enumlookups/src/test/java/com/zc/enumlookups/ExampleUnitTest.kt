package com.zc.enumlookups

import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun lookup_isCorrect() {
        val expected = Color.RED
        val value = Color.RED.ordinal
        val actual = lookup<Color>(value)
        assertEquals(expected, actual)
    }

    @Test
    fun lookupValue_isCorrect() {
        val expected = ColorType.RED
        val value = expected.hex
        val lookup = ColorType::hex.lookupByValue(value)
        assertEquals(expected, lookup)
    }

    @Test
    fun lookupName_isCorrect() {
        val expected = Color.BLUE
        val value = expected.name
        val actual = lookupByName<Color>(value)
        assertEquals(expected, actual)
    }

    @Test
    fun defaultLookup_isCorrect() {
        val expected = Color.RED
        val actual = lookupByName<Color>("green")
        assertEquals(expected, actual)
    }

    @Test
    fun customDefaultLookup_isCorrect() {
        val expected = ColorType.BLUE
        val actual = lookupByName("yellow", default = ColorType.BLUE)
        assertEquals(expected, actual)
    }

    @Test
    fun filterLookup_isCorrect() {
        val expected = listOf(ColorType.DARK_GREY, ColorType.GREY).map { it.hex }.toTypedArray()
        val actual = lookupFilter<ColorType>() {
            it.rgb.first == it.rgb.second && it.rgb.second == it.rgb.third
        }.map {
            it.hex
        }.toTypedArray()
        assertArrayEquals(expected, actual)
    }

    @Test
    fun operator_isCorrect() {
        val expected = ColorType.GREEN
        val value = expected.hex
        val actual = ColorType::hex from value
        assertEquals(expected, actual)
    }
}

enum class Color {
    RED, BLUE
}

enum class ColorType(val hex: String, val rgb: Triple<Int, Int, Int>) {
    RED("#FF0000", Triple(255, 0, 0)),
    GREEN("#00FF00", Triple(0, 255, 0)),
    BLUE("#0000FF", Triple(0, 0, 255)),
    DARK_GREY("##838383", Triple(131, 131, 131)),
    GREY("#a9a9a9", Triple(169, 169, 169))
}
