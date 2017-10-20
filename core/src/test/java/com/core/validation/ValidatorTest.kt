package com.core.validation

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Created by jhonnybarrios on 30-08-17.
 */
class ValidatorTest {
    private val emailValidator = EmailValidator()
    private val ppnPasswordValidator= PasswordValidator()

    @Test
    fun isEmpty() {
        assertFalse(emailValidator.isEmpty("HOLA"))
        assertTrue(emailValidator.isEmpty(""))
    }

    @Test
    fun isEmailValid() {
        assertFalse(emailValidator.isValid("jhonnyx"))
        assertFalse(emailValidator.isValid("jhonnyx2@gmail"))
        assertTrue(emailValidator.isValid("jhonnyx2012@gmail.com"))
        assertTrue(emailValidator.isValid("jhonnyx2012@mx.co.ve"))
    }

    @Test
    fun isPasswordValid() {
        assertFalse(ppnPasswordValidator.isValid("123"))
        assertFalse(ppnPasswordValidator.isValid(""))
        assertTrue(ppnPasswordValidator.isValid("1234"))
        assertTrue(ppnPasswordValidator.isValid("12345678"))
    }
}