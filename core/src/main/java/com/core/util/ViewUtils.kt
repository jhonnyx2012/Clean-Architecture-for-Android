package com.core.util

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.support.annotation.ColorRes
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v4.graphics.drawable.DrawableCompat
import android.view.View
import android.widget.ImageView
import com.core.R

/**
 * Created by tecnomei on 13-03-17.
 */

class ViewUtils {
    fun setTint(view: ImageView?, @ColorRes color: Int) {
        if (view == null) return
        view.setColorFilter(view.context.resources.getColor(color)) // White Tint
    }

    fun showOkSnackbar(view: View, @StringRes stringID: Int) {
        val snackbar = Snackbar.make(view, stringID, Snackbar.LENGTH_LONG)
        snackbar.setAction(R.string.ok) { snackbar.dismiss() }
        snackbar.show()
    }

    fun createTintList(colorPrimary: Int, colorPrimaryDark: Int): ColorStateList {
        val states = arrayOf(intArrayOf(android.R.attr.state_enabled), // enabled
                intArrayOf(-android.R.attr.state_enabled), // disabled
                intArrayOf(-android.R.attr.state_checked), // unchecked
                intArrayOf(android.R.attr.state_pressed)  // pressed
        )

        val colors = intArrayOf(colorPrimary, Color.GRAY, colorPrimary, colorPrimaryDark)
        return ColorStateList(states, colors)
    }

    fun getTintedDrawable(context: Context, idDrawable: Int, color: Int): Drawable {
        var drawable = context.resources.getDrawable(idDrawable)
        drawable = DrawableCompat.wrap(drawable)
        DrawableCompat.setTint(drawable.mutate(), color)
        return drawable
    }
}
