package dev.maples.me

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

@Composable
fun WebPageTheme(content: @Composable () -> Unit) {
    val colorScheme = darkColorScheme()

    MaterialTheme(
        colorScheme
    ) {
        content()
    }
}