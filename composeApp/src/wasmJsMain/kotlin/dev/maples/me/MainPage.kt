package dev.maples.me

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.Regular
import compose.icons.fontawesomeicons.brands.Github
import compose.icons.fontawesomeicons.brands.Linkedin
import compose.icons.fontawesomeicons.regular.Envelope
import maples_dev2.composeapp.generated.resources.Res
import maples_dev2.composeapp.generated.resources.me
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun Background(content: @Composable () -> Unit) {
    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .background(color = Color.Black),
    ) {
        Box(
            modifier =
                Modifier
                    .fillMaxSize()
                    .gradientBackground(
                        colors =
                            listOf(
                                Color(0x38ffa596),
                                Color(0x3864e4ff),
                            ),
                        angle = 60f,
                    ),
            contentAlignment = Alignment.Center,
        ) {
            content()
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "This page was made with Compose Multiplatform and Kotlin/Wasm! © Joe Maples",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White.copy(alpha = 0.6f),
                    modifier = Modifier.padding(bottom = 8.dp),
                )
            }
        }
    }
}

@Composable
fun LinksRow(size: Dp = 32.dp) {
    val uriHandler = LocalUriHandler.current

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(
            onClick = {
                uriHandler.openUri("https://www.linkedin.com/in/joseph-maples-253250170/")
            },
        ) {
            Icon(
                imageVector = FontAwesomeIcons.Brands.Linkedin,
                contentDescription = "LinkedIn",
                tint = Color.White,
                modifier = Modifier.size(size),
            )
        }

        Spacer(modifier = Modifier.width(size))

        IconButton(
            onClick = {
                uriHandler.openUri("https://github.com/frap129")
            },
        ) {
            Icon(
                imageVector = FontAwesomeIcons.Brands.Github,
                contentDescription = "Github",
                tint = Color.White,
                modifier = Modifier.size(size),
            )
        }

        Spacer(modifier = Modifier.width(size))

        IconButton(
            onClick = {
                uriHandler.openUri("mailto:joe@maples.dev")
            },
        ) {
            Icon(
                imageVector = FontAwesomeIcons.Regular.Envelope,
                contentDescription = "Mail",
                tint = Color.White,
                modifier = Modifier.size(size),
            )
        }
    }
}

@Composable
fun ProfileCard() {
    Card(
        modifier =
            Modifier
                .width(500.dp)
                .height(700.dp),
        shape = RoundedCornerShape(16.dp),
        elevation =
            CardDefaults.cardElevation(
                defaultElevation = 8.dp,
            ),
    ) {
        Column(
            modifier =
                Modifier
                    .padding(vertical = 32.dp, horizontal = 64.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(32.dp),
        ) {
            Spacer(modifier = Modifier.width(32.dp))
            Image(
                painter = painterResource(Res.drawable.me),
                contentDescription = "Joe Maples",
                modifier =
                    Modifier
                        .size(180.dp)
                        .clip(CircleShape),
                contentScale = ContentScale.Crop,
            )
            Text(
                text = "Joe Maples",
                style = MaterialTheme.typography.headlineLarge,
                color = Color.White,
            )

            Text(
                text = "Tinkerer, OSS Enthusiast, Coffee Snob,\nDeveloper",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge,
            )

            Text(
                text = "Senior Software Engineer at Valtech Detroit\n(formerly called Tome)",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge,
            )
            Text(
                text = "Former Lead Android Developer at Down To\nRide -DTR",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge,
            )

            Spacer(modifier = Modifier.width(64.dp))

            LinksRow()
        }
    }
}

@Preview
@Composable
fun ProfileCardPreview() {
    MaterialTheme {
        Background {
            ProfileCard()
        }
    }
}
