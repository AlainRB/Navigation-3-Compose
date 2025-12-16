package cu.xetid.navigation3compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import cu.xetid.navigation3compose.advance_navigation.AdvanceNavigationWrapper
import cu.xetid.navigation3compose.animation_navigation.AnimationNavigationWrapper
import cu.xetid.navigation3compose.ui.theme.Navigation3ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Navigation3ComposeTheme {
                AnimationNavigationWrapper()
            }
        }
    }
}
