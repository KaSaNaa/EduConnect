package com.retardeddev.educonnect.navigation

enum class Screen {
    HOME,
    UPDATES,
    PROFILE,
    SPLASH,
    SIGNUP,
    SIGNIN,
    COURSE_LIST
}
sealed class NavigationItem(val route: String) {
    object Home : NavigationItem(Screen.HOME.name)
    object Updates : NavigationItem(Screen.UPDATES.name)
    object Profile : NavigationItem(Screen.PROFILE.name)
    object Splash : NavigationItem(Screen.SPLASH.name)
    object Signup : NavigationItem(Screen.SIGNUP.name)
    object Signin : NavigationItem(Screen.SIGNIN.name)
    object CourseList : NavigationItem(Screen.COURSE_LIST.name)
}