
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.retardeddev.educonnect.navigation.NavigationItem
import com.retardeddev.educonnect.ui.pages.HomeScreen
import com.retardeddev.educonnect.ui.pages.ProfileScreen
import com.retardeddev.educonnect.ui.pages.SplashScreen
import com.retardeddev.educonnect.ui.pages.UpdatesScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Splash.route,

    ) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Splash.route) {
            SplashScreen()
        }
        composable(NavigationItem.Home.route) {
            HomeScreen()
        }
        composable(NavigationItem.Profile.route) {
            ProfileScreen()
        }
        composable(NavigationItem.Updates.route) {
            UpdatesScreen()
        }
    }
}