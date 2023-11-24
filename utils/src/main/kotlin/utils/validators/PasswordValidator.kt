package utils.validators

import utils.validators.counter.AmountRestriction

class PasswordValidator: Validator  {
    override val permittedChars: List<Char>
        get() = emptyList()
    override val prohibitedChars: List<Char>
        get() = emptyList()
    override val amountRestriction: AmountRestriction
        get() = AmountRestriction.SymbolsAmount(8..50)

    override fun validate(value: String): Boolean {
        return  when(amountRestriction){
            is AmountRestriction.SymbolsAmount -> value.length in (amountRestriction as AmountRestriction.SymbolsAmount).amount
            AmountRestriction.NoAmountRestriction ->  true
        }

    }

}