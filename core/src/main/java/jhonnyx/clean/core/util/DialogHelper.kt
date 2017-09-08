package jhonnyx.clean.core.util

import android.content.Context
import android.support.annotation.StringRes
import android.support.v7.app.AlertDialog
import jhonnyx.clean.core.R

/**
 * Created by jhonnybarrios on 21-04-17.
 */

class DialogHelper {
    private lateinit var context: Context
    private var dialog: AlertDialog? = null

    fun attachContext(context: Context) {
        this.context = context
    }

    fun showMessageDialog(idString: Int) {
        showMessageDialog(context.getString(idString))
    }

    fun showErrorDialog(idString: Int) {
        showErrorDialog(context.getString(idString))
    }

    fun showErrorDialog(text: String) {
        showMessageDialog(text, R.string.ups)
    }

    fun showMessageDialog(text: String, @StringRes title: Int = R.string.app_name) {
        if (dialog != null && dialog!!.isShowing) {
            dialog!!.cancel()
            dialog = null
        }
        try {
            val builder = AlertDialog.Builder(context, R.style.DialogLight)
            dialog = builder.setCancelable(false)
                    .setTitle(title)
                    .setMessage(text)
                    .setPositiveButton(R.string.ok) { dialog, _ -> dialog.cancel() }.create()
            dialog!!.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
