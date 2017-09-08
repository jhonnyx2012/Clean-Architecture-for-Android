package jhonnyx.clean.core.data.local.preferences

import android.content.Context
import android.content.SharedPreferences
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.Mockito.times
import org.mockito.Mockito.`when`

/**
 * Created by jhonnybarrios on 31-08-17.
 */
class PreferencesTest {

    private lateinit var mockPreferences: MockPreferences
    private lateinit var preferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    private val DEFAULT_STRING=""

    class MockPreferences(context: Context) : Preferences(context) {
        override val name: String get() = "MockPreferences"
    }

    enum class Key {
        INT, STRING, BOOL
    }

    @Before
    fun setUp(){
        preferences = Mockito.mock(SharedPreferences::class.java)
        editor = Mockito.mock(SharedPreferences.Editor::class.java)
        `when`(preferences.edit()).thenReturn(editor)
        `when`(editor.clear()).thenReturn(editor)
        val context = Mockito.mock(Context::class.java)
        `when`(context.getSharedPreferences("MockPreferences",Context.MODE_PRIVATE)).thenReturn(preferences)
        mockPreferences = MockPreferences(context)
    }

    private fun verifySave() {
        verify(editor, times(1)).commit()
        verify(editor, times(1)).apply()
    }

    @Test
    fun clear() {
        mockPreferences.clear()
        verify(editor, times(1)).clear()
        verify(editor, times(1)).commit()
    }

    @Test
    fun save() {
        mockPreferences.save()
        verifySave()
    }

    @Test
    fun saveInt() {
        val integer=30
        mockPreferences.save(Key.INT,integer)
        verify(editor, times(1)).putInt(Key.INT.name,integer)
        verifySave()
    }

    @Test
    fun saveString() {
        val string="hola"
        mockPreferences.save(Key.STRING,string)
        verify(editor, times(1)).putString(Key.STRING.name,string)
        verifySave()
    }

    @Test
    fun saveBool() {
        val bool=false
        mockPreferences.save(Key.BOOL,bool)
        verify(editor, times(1)).putBoolean(Key.BOOL.name,bool)
        verifySave()
    }

    @Test
    fun getInt() {
        mockPreferences.getInt(Key.INT)
        verify(preferences, times(1)).getInt(Key.INT.name,-1)
    }

    @Test
    fun getString() {
        `when`(preferences.getString(Key.STRING.name,DEFAULT_STRING)).thenReturn(DEFAULT_STRING)
        mockPreferences.getString(Key.STRING)
        verify(preferences, times(1)).getString(Key.STRING.name,DEFAULT_STRING)
    }

    @Test
    fun getBool() {
        mockPreferences.getBool(Key.BOOL)
        verify(preferences, times(1)).getBoolean(Key.BOOL.name,false)
    }
}