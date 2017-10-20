package com.core.validation

import android.content.Context
import android.content.res.Resources
import android.support.design.widget.TextInputLayout
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.Mockito.times

/**
 * Created by jhonnybarrios on 30-08-17.
 */
class FieldValidatorHelperTest {
    private lateinit var fieldValidatorHelper:FieldValidatorHelper

    private val FAKE_STRING="fake string"
    private val FAKE_STRING_ID=3030
    private lateinit var resources :Resources
    private lateinit var textInputLayout :TextInputLayout

    @Before
    fun setUp(){
        val context = Mockito.mock(Context::class.java)
        resources=Mockito.mock(Resources::class.java)
        textInputLayout = Mockito.mock(TextInputLayout::class.java)
        `when`(context.resources).thenReturn(resources)
        `when`(resources.getString(FAKE_STRING_ID)).thenReturn(FAKE_STRING)
        `when`(textInputLayout.error).thenReturn("error")
        `when`(textInputLayout.isErrorEnabled).thenReturn(true)
        fieldValidatorHelper= FieldValidatorHelper(context)
    }

    @Test
    fun clearErrorFromField() {
        fieldValidatorHelper.clearErrorFromField(textInputLayout)
        verify(textInputLayout,times(1)).error=null
        verify(textInputLayout,times(1)).isErrorEnabled=false
    }

    @Test
    fun setErrorToField() {
        fieldValidatorHelper.setErrorToField(textInputLayout,FAKE_STRING_ID)
        verify(resources).getString(FAKE_STRING_ID)
        verify(textInputLayout, times(1)).requestFocus()
        verify(textInputLayout, times(1)).error=FAKE_STRING
        verify(textInputLayout, times(1)).isErrorEnabled=true
    }

    @Test
    fun clearErrorFromFields() {
        fieldValidatorHelper.clearErrorFromFields(textInputLayout,textInputLayout,textInputLayout)
        verify(textInputLayout,times(3)).error=null
        verify(textInputLayout,times(3)).isErrorEnabled=false
    }
}