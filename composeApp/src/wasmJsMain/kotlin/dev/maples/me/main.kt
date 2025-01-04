package dev.maples.me

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import dev.maples.me.ui.App
import kotlinx.browser.document
import org.koin.compose.KoinApplication
import org.koin.dsl.module

val mainModule = module {  }

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(document.body!!) {
        KoinApplication(
            application = {
                modules(mainModule)
            }
        ) {
            App()
        }
    }
}
