package com.core.presentation.ui.fragment

import android.os.Bundle
import android.view.View
import com.core.presentation.presenter.contracts.IProgressView
import com.core.util.DialogHelper
import javax.inject.Inject

/**
 * Created by Jhonny Barrios
 *
 * A fragment like an activity only will execute operations that affect the UI.
 * These operations are defined by a view model and are triggered by its presenter.
 *
 */
abstract class BaseLoadingFragment : BaseFragment(), IProgressView {

    @Inject lateinit var loadingDialogFragment: LoadingDialogFragment

    @Inject lateinit var dialogManager: DialogHelper

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialogManager.attachContext(CONTEXT)
    }

    override fun showProgress(show: Boolean) {
        if (!show)
            loadingDialogFragment.dismiss()
        else if (!loadingDialogFragment.isVisible && activity!=null)
            loadingDialogFragment.show(activity.fragmentManager, LoadingDialogFragment.TAG)
    }

    override fun showMessageError(message: String) {
        dialogManager.showErrorDialog(message)
    }

    override fun showMessage(message: String) {
        dialogManager.showMessageDialog(message)
    }
}