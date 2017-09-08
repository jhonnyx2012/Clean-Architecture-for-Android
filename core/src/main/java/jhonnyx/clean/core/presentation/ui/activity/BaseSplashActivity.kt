package jhonnyx.clean.core.presentation.ui.activity

import android.os.Bundle
import android.os.Handler
import android.view.Window

abstract class BaseSplashActivity : BaseActivity() {

    protected abstract val splashTime: Int

    protected abstract fun openNextActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
    }

    override fun injectDependencies() {}

    override fun initView() {
        hideActionBar()
        Handler().postDelayed({ openNextActivity() }, splashTime.toLong())
    }

    private fun hideActionBar() {
        supportActionBar?.hide()
    }

    override fun startActivity(activityClass: Class<*>) {
        finish()
        super.startActivity(activityClass)
    }
}