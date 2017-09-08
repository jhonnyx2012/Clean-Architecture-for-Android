package com.papinotas.core.presentation.ui.activity

import android.os.Bundle
import jhonnyx.clean.core.presentation.ui.fragment.LoadingDialogFragment
import jhonnyx.clean.core.presentation.presenter.contracts.IProgressView
import jhonnyx.clean.core.presentation.ui.activity.BaseActivity
import jhonnyx.clean.core.util.DialogHelper
import javax.inject.Inject

/**
 * Created by Jhonny Barrios on 23/08/2017.
 */

abstract class BaseLoadingActivity : BaseActivity(), IProgressView {

    @Inject lateinit var loadingDialogFragment: LoadingDialogFragment

    @Inject lateinit var dialogManager: DialogHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dialogManager.attachContext(this)
    }

    override fun showProgress(show: Boolean) {
        if (!show)
            loadingDialogFragment.dismiss()
        else if (!loadingDialogFragment.isVisible)
            loadingDialogFragment.show(fragmentManager, LoadingDialogFragment.TAG)
    }

    override fun showMessageError(message: String) {
        dialogManager.showErrorDialog(message)
    }

    override fun showMessage(message: String) {
        dialogManager.showMessageDialog(message)
    }
}