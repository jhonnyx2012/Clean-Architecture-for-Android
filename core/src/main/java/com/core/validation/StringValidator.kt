package com.core.validation

/**
 * Created by jhonnybarrios on 29-08-17.
 */

abstract class StringValidator : Validator {
    fun isEmpty(value: String): Boolean = value.trim().isEmpty()
}