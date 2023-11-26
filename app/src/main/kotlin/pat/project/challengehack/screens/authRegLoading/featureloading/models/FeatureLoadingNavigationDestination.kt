package pat.project.challengehack.screens.authRegLoading.featureloading.models

sealed class FeatureLoadingNavigationDestination {
    object Default : FeatureLoadingNavigationDestination()
    object WelcomePage : FeatureLoadingNavigationDestination()
    object Main : FeatureLoadingNavigationDestination()
}