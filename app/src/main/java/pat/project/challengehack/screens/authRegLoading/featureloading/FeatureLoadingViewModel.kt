package pat.project.challengehack.screens.authRegLoading.featureloading

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FeatureLoadingViewModel @Inject constructor(
//    private val authInteractor: AuthInteractor
) : ViewModel(){
//    private var _navDestination : MutableStateFlow<FeatureLoadingNavigationDestination> = MutableStateFlow(
//        FeatureLoadingNavigationDestination.Default)
//    val navDestination = _navDestination.asStateFlow()
//
//    init {
//        viewModelScope.launch {
//            when(authInteractor.verifyAccess()){
//                is Entity.Success -> {
//                    _navDestination.value = FeatureLoadingNavigationDestination.Main
//                }
//                is Entity.Error -> {
//                    _navDestination.value = FeatureLoadingNavigationDestination.WelcomePage
//                }
//            }
//
//        }
//    }
}