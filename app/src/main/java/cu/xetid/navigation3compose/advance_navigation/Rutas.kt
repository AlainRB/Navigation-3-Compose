package cu.xetid.navigation3compose.advance_navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Rutas : NavKey {

    @Serializable
    data object Home3 : Rutas()

    @Serializable
    data class Detail3(val id: String) : Rutas()

    @Serializable
    data object Error3 : Rutas()


}