package jhonnyx.clean.core.data.local.preferences

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
/**
 * Created by tecnomei on 17-03-17.
 */
@SuppressLint("CommitPrefEdits")
abstract class Preferences constructor(context: Context) : IPreferences {
    protected var sharedPref: SharedPreferences
    protected var edit: SharedPreferences.Editor

    init {
        sharedPref = context.getSharedPreferences(name, Context.MODE_PRIVATE)
        edit=sharedPref.edit()
    }

    /**
     * delete all values in the preference
     */
    override fun clear() {
        edit.clear().commit()
    }

    /**
     * Save all the changes in the preference
     */
    override fun save() {
        edit.commit()
        edit.apply()
    }

    /**
     * Save a the value to the preference with that key
     * @param key
     * @param value
     */
    override fun save(key: Enum<*>, value: Int) {
        edit.putInt(key.name, value)
        save()
    }

    override fun save(key: Enum<*>, value: String) {
        edit.putString(key.name, value)
        save()
    }

    override fun save(key: Enum<*>, value: Boolean) {
        edit.putBoolean(key.name, value)
        save()
    }

    /**
     * If you need to return a different default response then
     * override this method with yor implementation
     * @param key
     * @return
     */
    override fun getInt(key: Enum<*>): Int = getInt(key,-1)

    protected fun getInt(key: Enum<*>, defaultValue:Int ): Int = sharedPref.getInt(key.name, defaultValue)

    /**
     * If you need to return a different default response then
     * override this method with yor implementation
     * @param key
     * @return
     */
    override fun getString(key: Enum<*>): String = getString(key, "")

    /**
     * Returns the value of the key or the default value
     * @param key
     * @return
     */
    protected fun getString(key: Enum<*>, defaultValue: String): String = sharedPref.getString(key.name, defaultValue)

    /**
     * If you need to return a different default response then
     * override this method with yor implementation
     * @param key
     * @return
     */
    override fun getBool(key: Enum<*>): Boolean = sharedPref.getBoolean(key.name, false)
}