package com.core.presentation.ui.fragment
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import android.view.*
import butterknife.ButterKnife
import butterknife.Unbinder
import com.core.R
import com.core.presentation.ui.activity.BaseActivity
import com.core.util.StackNavigationController

/**
 * Created by Jhonny Barrios
 *
 * A fragment like an activity only will execute operations that affect the UI.
 * These operations are defined by a view model and are triggered by its presenter.
 *
 */
abstract class BaseFragment : Fragment(){
    private var mToolbar: Toolbar? = null
    protected lateinit var CONTEXT: Context
    private lateinit var unbinder: Unbinder
    public lateinit var stackNavigationController: StackNavigationController
    private var currentOrientation: Int = 0
    private var orientationHasChange: Boolean = false

    /**
     * Specify the layout of the fragment to be inflated in the [BaseFragment.onCreateView]
     */
    @get:LayoutRes protected abstract val fragmentLayout: Int

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context!=null)
            CONTEXT = context
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies()
        orientationHasChange = false
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater!!.inflate(fragmentLayout, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mToolbar = view!!.findViewById(R.id.toolbar)
        if (mToolbar != null) {
            (activity as BaseActivity).setSupportActionBar(mToolbar)
        }
        bindViews(view)
        initView()
    }

    open fun isBaseStackFragment(): Boolean {
        return false
    }

    open fun getBaseStackFragment(): BaseFragment? {
        if (isBaseStackFragment())
            return this
        while (true) {
            val parent = parentFragment as BaseFragment ?: return null
            if (parent.isBaseStackFragment())
                return parent
        }
    }

    fun orientationHasChange(): Boolean {
        return orientationHasChange
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater!!.inflate(getMenuId(), menu)
        recreateMenu()
    }

    open fun getMenuId(): Int {
        return R.menu.empty_menu
    }

    open fun recreateMenu(): Menu? {
        if (mToolbar== null) return null
        mToolbar!!.menu.clear()
        mToolbar!!.inflateMenu(getMenuId())
        return mToolbar!!.menu
    }

    open fun startActivity(activityClass: Class<*>) {
        if(activity!=null){
            val i = Intent(activity, activityClass)
            startActivity(i)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        unbinder.unbind()
    }

    fun finishActivity() {
        if(activity!=null)
            activity.finish()
    }

    /**
     * Use this method to initialize view components. This method is called after [ ][BaseFragment.onViewCreated]
     */
    abstract fun initView()

    /**
     * Override this method in case you need to inject dependencies
     */
    abstract fun injectDependencies()

    /**
     * Replace all the annotated fields with ButterKnife annotations with the proper value
     */
    private fun bindViews(rootView: View?) {
        unbinder = ButterKnife.bind(this, rootView!!)
    }

    /**
     * Provee al fragment la posibilidad de saber cuando se quiere hacer back,
     * ademas de decidir si puede o no ejecutar el back.
     * @return true si la actividad puede hacer back
     */
    open fun allowBackPressed(): Boolean { return true }

    protected fun showUpButton(show: Boolean) {
        (activity as BaseActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(show)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean = when (item!!.itemId) {
        android.R.id.home -> {
            activity.onBackPressed()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    protected fun restartActivity() {
        (activity as BaseActivity).restartActivity()
    }


    fun popBackStack() {
        activity.supportFragmentManager.popBackStack()
    }

    fun clearBackStack() {
        val base = getBaseStackFragment()
        base?.stackNavigationController?.clearBackStack()
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        val orientation = resources.configuration.orientation
        orientationHasChange = orientation != currentOrientation
        currentOrientation = orientation
    }
}