package cu.xetid.navigation3compose.animation_navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import cu.xetid.navigation3compose.advance_navigation.Rutas.Detail3
import cu.xetid.navigation3compose.advance_navigation.Rutas.Error3
import cu.xetid.navigation3compose.advance_navigation.Rutas.Home3
import cu.xetid.navigation3compose.core.extension.back
import cu.xetid.navigation3compose.core.extension.navigateTo
import cu.xetid.navigation3compose.screen.DetailScreen
import cu.xetid.navigation3compose.screen.HomeScreen


@Composable
fun AnimationNavigationWrapper() {
    val backStack = rememberNavBackStack(Home3)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Home3> {
                HomeScreen() {
                    //backStack.add(Detail3(it))
                    backStack.navigateTo(Detail3(it))
                }
            }
            entry<Detail3> {
                DetailScreen(it.id) {
                    backStack.back()
                }

            }
            entry<Error3> {
                Text("Error")
            }
        },
        transitionSpec = {//Animacion de entrada
            slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = tween(500),
            ) togetherWith slideOutHorizontally(
                targetOffsetX = { -it },
                animationSpec = tween(500),
            )

        },
        popTransitionSpec = {//Animacion de Salida
            slideInHorizontally(
                initialOffsetX = { -it },
                animationSpec = tween(500),
            ) togetherWith slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(500),
            )

        },
        predictivePopTransitionSpec = {//Animacion de salida para android >13
            slideInHorizontally(
                initialOffsetX = { -it },
                animationSpec = tween(500),
            ) togetherWith slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(500),
            )
        }

    )
}