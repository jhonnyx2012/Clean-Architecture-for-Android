package com.core.validation

/**
 * Created by jhonnybarrios on 29-08-17.
 */

class PasswordValidator : StringValidator() {

    companion object {
        private val MIN_CHARACTERS = 4
    }
    override fun isValid(value: String): Boolean = !isEmpty(value) && value.length >= MIN_CHARACTERS
}