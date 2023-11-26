package pat.project.challengehack.screens.authRegLoading.featureloading

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import basic.domain.auth.interactors.AuthInteractor
import common.domain.entity.Entity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import pat.project.challengehack.screens.authRegLoading.featureloading.models.FeatureLoadingNavigationDestination
import javax.inject.Inject

@HiltViewModel
class FeatureLoadingViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
) : ViewModel(){
    private var _navDestination : MutableStateFlow<FeatureLoadingNavigationDestination> = MutableStateFlow(
        FeatureLoadingNavigationDestination.Default)
    val navDestination = _navDestination.asStateFlow()

    init {
        viewModelScope.launch {
            when(authInteractor.verifyAccess()){
                is Entity.Success -> {
                    _navDestination.value = FeatureLoadingNavigationDestination.Main
                }
                is Entity.Error -> {
                    _navDestination.value = FeatureLoadingNavigationDestination.WelcomePage
                }
            }

        }
    }
}