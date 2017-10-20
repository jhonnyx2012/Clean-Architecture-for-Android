package com.core.presentation.ui.activity

/**
 * Created by jhonnybarrios on 10/20/17.
 */
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Window
import com.core.R
import com.core.presentation.ui.fragment.BaseFragment

abstract class BaseFragmentActivity : BaseLoadingActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
    }

    fun setFragment(fragment: Fragment) {
        setFragment(fragment, false)
    }

    fun setFragment(fragment: Fragment, idContainer: Int) {
        setFragment(fragment, idContainer, false)
    }

    fun setFragment(fragment: Fragment, addToBackStack: Boolean) {
        setFragment(fragment, getFragmentContainerId(), addToBackStack)
    }

    abstract fun getFragmentContainerId(): Int

    fun setFragment(fragment: Fragment, idContainer: Int, addToBackStack: Boolean) {
        val trans = supportFragmentManager.beginTransaction()
        if (addToBackStack)
            trans.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        trans.replace(idContainer, fragment)
        if (addToBackStack)
            trans.addToBackStack(fragment.tag)
        trans.commit()
    }

    protected var topFragment: Fragment? = null

    fun addFragment(fragment: Fragment, show: Boolean) {
        val trans = supportFragmentManager.beginTransaction()
                .add(getFragmentContainerId(), fragment)
        if (!show)
            trans.hide(fragment)
        else
            topFragment = fragment
        trans.commit()
    }

    fun hideFragment(fragment: Fragment?) {
        if (fragment == null) return
        supportFragmentManager.beginTransaction().hide(fragment).commit()
    }

    fun showFragment(fragmemt: Fragment) {
        supportFragmentManager.beginTransaction().show(fragmemt).commit()
        if (topFragment != null && topFragment!! != fragmemt)
            hideFragment(topFragment)
        topFragment = fragmemt
    }

    override fun onBackPressed() {
        val actualFragment = getActualFragment()
        val canBack = actualFragment == null || actualFragment.allowBackPressed()
        try {
            if (canBack)
                super.onBackPressed()
        } catch (ignored: Exception) {}
    }

    open fun getActualFragment(): BaseFragment?{
        return supportFragmentManager.findFragmentById(getFragmentContainerId()) as BaseFragment?
    }
}