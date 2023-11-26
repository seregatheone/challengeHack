package core.ui.components.snackbar

sealed class SnackBarStates(val result: Boolean = false, val message : String? = null) {
    class Init : SnackBarStates()
    class Success(result: Boolean) : SnackBarStates(result)
    class Error(result : Boolean, message : String): SnackBarStates(result,message)
}