package jhonnyx.clean.core.presentation.presenter.contracts

/**
 * Created by tecnomei on 13-03-17.
 */

interface IProgressView {
    fun showProgress(show: Boolean)
    fun showMessageError(message: String)
    fun showMessage(message: String)
}