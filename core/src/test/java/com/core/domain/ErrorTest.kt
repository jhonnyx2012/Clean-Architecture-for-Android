package com.core.domain

import org.junit.Test
import kotlin.test.assertTrue

/**
 * Created by jhonnybarrios on 30-08-17.
 */
class ErrorTest{
    @Test
    fun checkErrorEnum(){
        assertTrue(Error.INTERNET.name == "INTERNET")
        assertTrue(Error.SERVER.name == "SERVER")
        assertTrue(Error.USER.name == "USER")
        assertTrue(Error.values().size==3)
    }
}