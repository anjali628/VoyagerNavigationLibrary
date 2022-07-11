package com.demo.voyagernavigationlibrary.bottomNavigation

import android.app.ActionBar
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.*
import com.demo.voyagernavigationlibrary.ui.theme.VoyagerNavigationLibraryTheme

class BottomNavigationActivity :ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            VoyagerNavigationLibraryTheme(){
                androidx.compose.material.Surface {

                    TabNavigator(tab = HomeTab){
                        Scaffold(
                            bottomBar = {
                                BottomNavigation() {
                                    TabNavigationItems(tab = HomeTab)
                                    TabNavigationItems(tab = ProfileTab)
                                }
                            }
                        ) {

                            CurrentTab()
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun RowScope.TabNavigationItems(tab: Tab){
    
    val tabNavigator = LocalTabNavigator.current
    BottomNavigationItem(selected = tabNavigator.current == tab , onClick = { tabNavigator.current = tab },
    icon = { Icon(tab.options.icon!!, contentDescription = tab.options.title)})
}

object HomeTab : Tab {

    override val options: TabOptions
        @Composable
        get() {

            val title = "Home"
            val icon = rememberVectorPainter(image = Icons.Default.Home)

            return remember {
                TabOptions(
                    0u,
                    title,
                    icon
                )
            }
        }


    @Composable
    override fun Content() {
        Text(text = "Home")
    }

}


object ProfileTab : Tab{

    override val options: TabOptions
    @Composable
        get() {
            val title ="Profile"
        val icon = rememberVectorPainter(image = Icons.Default.Person)

        return remember{
            TabOptions(
            1u,
            title,
            icon
            )

        }

    }

    @Composable
    override fun Content() {
        Text(text = "Profile")
    }

}