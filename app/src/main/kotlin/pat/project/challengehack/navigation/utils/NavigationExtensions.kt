package pat.project.challengehack.navigation.utils

import androidx.navigation.NavController


fun NavController.navigateAndClean(
    destination: String,
//    args: Bundle?
) {
    this.navigate(destination) { popUpTo(0) }
}

//fun NavController.navigateWithCallBack(destination: String, callback: () -> Unit) {
//    navigate(route = destination)
//    callback()
//}

//fun NavController.navigateAndCleanWithCallBack(destination: String, callback: () -> Unit) {
//    navigateAndClean(destination)
//    callback()
//}

//fun NavController.popBackStackWithCallBack(callback: () -> Unit) {
//    popBackStack()
//    callback()
//}

