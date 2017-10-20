package com.core.presentation.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.annotation.MenuRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import com.core.R

/**
 * Created by Jhonny Barrios on 23/08/2017.
 *
 * The activity only will execute operations that affect the UI. These operations
 * are triggered by its presenter.
 *
 */
abstract class BaseActivity : AppCompatActivity() {

    protected var mToolbar: Toolbar? = null
    private var unbinder: Unbinder? = null
    @get:LayoutRes protected abstract val layout: Int
    protected open val menuId: Int @MenuRes get() = R.menu.empty_menu

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(menuId, menu)
        return true
    }

    /**
     * The onCreate base will init this view
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        setTransitionAnimations()
        super.onCreate(savedInstanceState)
        setContentView(layout)
        injectDependencies()
        injectViews()
        setupToolbar()
        initView()
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindViews()
    }

    /**
     * Setup the object graph and inject the dependencies needed on this activity.
     */
    abstract fun injectDependencies()

    abstract fun initView()

    fun setupToolbar() {
        mToolbar = findViewById(R.id.toolbar) as Toolbar?
        setSupportActionBar(mToolbar)
    }

    /**
     * Every object annotated with [BindView] its gonna injected trough butterknife
     */
    fun injectViews() {
        unbinder = ButterKnife.bind(this)
    }

    open fun startActivity(activityClass: Class<*>) {
        val i = Intent(this, activityClass)
        startActivity(i)
    }

    private fun unbindViews() {
        unbinder?.unbind()
    }

    fun setTransitionAnimations() {
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }

    protected fun getFragmentStack(): List<Fragment> = supportFragmentManager.fragments

    fun restartActivity() {
        val intent = intent
        finish()
        startActivity(intent)
    }
}