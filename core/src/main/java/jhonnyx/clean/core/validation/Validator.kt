package jhonnyx.clean.core.validation

/**
 * Created by jhonnybarrios on 29-08-17.
 */

interface Validator {
    fun isValid(value: String): Boolean
}