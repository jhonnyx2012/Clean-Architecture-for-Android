package jhonnyx.clean.core.presentation.ui.fragment

import android.content.Context
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.Unbinder

/**
 * Created by Jhonny Barrios
 *
 * A fragment like an activity only will execute operations that affect the UI.
 * These operations are defined by a view model and are triggered by its presenter.
 *
 */
abstract class BaseFragment : Fragment() {

    protected lateinit var CONTEXT: Context
    private lateinit var unbinder: Unbinder

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
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater!!.inflate(fragmentLayout, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews(view)
        initView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        unbinder.unbind()
    }

    /**
     * Use this method to initialize view components. This method is called after [ ][BaseFragment.onViewCreated]
     */
    fun initView() {}

    /**
     * Override this method in case you need to inject dependencies
     */
    fun injectDependencies() {}

    /**
     * Replace all the annotated fields with ButterKnife annotations with the proper value
     */
    private fun bindViews(rootView: View?) {
        unbinder = ButterKnife.bind(this, rootView!!)
    }
}