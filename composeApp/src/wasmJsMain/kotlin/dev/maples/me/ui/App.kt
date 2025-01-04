package dev.maples.me.ui

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import dev.maples.me.ui.theme.WebPageTheme

@Composable
fun App() {
    WebPageTheme {
        Navigator(screen = MainScreen())
    }
}
