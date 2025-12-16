package cu.xetid.navigation3compose.advance_navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import cu.xetid.navigation3compose.advance_navigation.Rutas.*
import cu.xetid.navigation3compose.screen.DetailScreen
import cu.xetid.navigation3compose.screen.HomeScreen

@Composable
fun AdvanceNavigationWrapper() {
    val backStack = rememberNavBackStack(Home3)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Home3> {
                HomeScreen() {
                    backStack.add(Detail3(it))
                }
            }
            entry<Detail3> {
                DetailScreen(it.id) {
                    backStack.removeLastOrNull()
                }

            }
            entry<Error3> {
                Text("Error")
            }
        }
        /* entryProvider = { key ->
             when (key) {
                 is Home3 -> NavEntry(key) {
                     HomeScreen() {
                         backStack.add(Detail3(it))
                     }
                 }

                 is Detail3 -> NavEntry(key) {
                     DetailScreen(key.id) {
                         backStack.removeLastOrNull()
                     }
                 }

                 else -> NavEntry(key = Error3) {
                     Text("Error")
                 }
             }
         }*/

    )
}