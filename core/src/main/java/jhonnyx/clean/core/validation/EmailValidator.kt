package jhonnyx.clean.core.validation

import java.util.regex.Pattern

/**
 * Created by jhonnybarrios on 29-08-17.
 */

class EmailValidator : StringValidator() {
    private val pattern = Pattern.compile("^.+@.+\\..+$")

    override fun isValid(value: String): Boolean = pattern.matcher(value).matches()
}