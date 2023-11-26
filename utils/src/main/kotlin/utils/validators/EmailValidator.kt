package utils.validators

import android.text.TextUtils
import android.util.Patterns
import utils.validators.counter.AmountRestriction

class EmailValidator: Validator {
    override val permittedChars: List<Char>
        get() = emptyList()
    override val prohibitedChars: List<Char>
        get() = emptyList()
    override val amountRestriction: AmountRestriction
        get() = AmountRestriction.SymbolsAmount(3..50)

    override fun validate(value: String): Boolean {
        return if (TextUtils.isEmpty(value)||value == null) {
            false
        } else {
            Patterns.EMAIL_ADDRESS.matcher(value).matches()
        }
    }
}