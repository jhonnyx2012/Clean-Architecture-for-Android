package jhonnyx.clean.core.util

import android.content.Context
import org.junit.Before
import org.mockito.Mockito

/**
 * Created by jhonnybarrios on 30-08-17.
 */
class DialogHelperTest {
    private val helper=DialogHelper()
    private val FAKE_STRING="fake string"
    private val FAKE_STRING_ID=3030

    @Before
    fun setUp() {
        val context = Mockito.mock(Context::class.java)
        Mockito.`when`(context.getString(FAKE_STRING_ID)).thenReturn(FAKE_STRING)
        helper.attachContext(context)
    }
}