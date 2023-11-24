package utils.validators

import utils.validators.counter.AmountRestriction

interface Validator {
    val permittedChars : List<Char>
    val prohibitedChars : List<Char>
    val amountRestriction : AmountRestriction
    fun validate(value : String) : Boolean
}