package utils.validators.counter

sealed class AmountRestriction {
    object NoAmountRestriction : AmountRestriction()
    class SymbolsAmount(val amount : IntRange) : AmountRestriction()
}