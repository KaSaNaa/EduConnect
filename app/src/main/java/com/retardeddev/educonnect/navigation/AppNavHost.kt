
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.retardeddev.educonnect.navigation.NavigationItem
import com.retardeddev.educonnect.ui.components.BottomBar
import com.retardeddev.educonnect.ui.pages.HomeScreen
import com.retardeddev.educonnect.ui.pages.ProfileScreen
import com.retardeddev.educonnect.ui.pages.SplashScreen
import com.retardeddev.educonnect.ui.pages.UpdatesScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Splash.route
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Splash.route) {
            SplashScreen(navController)
        }
        composable(NavigationItem.Home.route) {
            ScreenWithBottomBar(navController) {
                HomeScreen()
            }
        }
        composable(NavigationItem.Profile.route) {
            ScreenWithBottomBar(navController) {
                ProfileScreen()
            }
        }
        composable(NavigationItem.Updates.route) {
            ScreenWithBottomBar(navController) {
                UpdatesScreen()
            }
        }
    }
}

@Composable
fun ScreenWithBottomBar(navController: NavController, screenContent: @Composable () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        screenContent()
        BottomBar(navController = navController)
    }
}