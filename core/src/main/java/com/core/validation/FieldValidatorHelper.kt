package com.core.validation

import android.content.Context
import android.content.res.Resources
import android.support.annotation.StringRes
import android.support.design.widget.TextInputLayout

/**
 * Created by jhonnybarrios on 21-04-17.
 */

class FieldValidatorHelper(context: Context) {
    private val resources: Resources = context.resources

    fun clearErrorFromFields(vararg fields: TextInputLayout) {
        for (field in fields) {
            clearErrorFromField(field)
        }
    }

    fun clearErrorFromField(input: TextInputLayout) {
        input.isErrorEnabled = false
        input.error = null
    }

    fun setErrorToField(textInputLayout: TextInputLayout, @StringRes error: Int) {
        setErrorToField(textInputLayout, resources.getString(error))
    }

    fun setErrorToField(textInputLayout: TextInputLayout, error: String) {
        textInputLayout.isErrorEnabled = true
        textInputLayout.error = error
        textInputLayout.requestFocus()
    }
}