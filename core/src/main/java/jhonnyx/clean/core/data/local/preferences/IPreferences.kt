package jhonnyx.clean.core.data.local.preferences

/**
 * Created by jhonnybarrios on 24-08-17.
 */

internal interface IPreferences {
    val name: String
    fun clear()
    fun save()
    fun save(key: Enum<*>, value: Int)
    fun save(key: Enum<*>, value: String)
    fun save(key: Enum<*>, value: Boolean)
    fun getInt(key: Enum<*>): Int
    fun getString(key: Enum<*>): String
    fun getBool(key: Enum<*>): Boolean
}