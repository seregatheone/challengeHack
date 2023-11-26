package pat.project.challengehack.screens.authRegLoading.welcomepage.model

sealed class WelcomePageNavigationDestination {
    object Default : WelcomePageNavigationDestination()
    object Authorization : WelcomePageNavigationDestination()
    object Registration : WelcomePageNavigationDestination()
}