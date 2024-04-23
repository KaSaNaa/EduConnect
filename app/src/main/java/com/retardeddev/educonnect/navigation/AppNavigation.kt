package com.retardeddev.educonnect.navigation

enum class Screen {
    HOME,
    UPDATES,
    PROFILE,
    SPLASH
}
sealed class NavigationItem(val route: String) {
    object Home : NavigationItem(Screen.HOME.name)
    object Updates : NavigationItem(Screen.UPDATES.name)
    object Profile : NavigationItem(Screen.PROFILE.name)
    object Splash : NavigationItem(Screen.SPLASH.name)
}