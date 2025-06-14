package ir.sbpro.aventronix.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import ir.sbpro.aventronix.R
import ir.sbpro.aventronix.resources.AvtImageResources
import ir.sbpro.aventronix.ui.dxp
import ir.sbpro.aventronix.ui.sxp

@Composable
fun DefaultButton(title: String, height: Int, callback: () -> Unit) {
    val width = height * 3

    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .clip(shape = RectangleShape)
            .padding(bottom = 8.dxp)
            .width(width.dxp)
            .height(height.dxp)
            .clickable {
                callback()
            }
    ) {
        Image(
            painter = AvtImageResources.rememberImage(R.drawable.button_red),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
            modifier = Modifier.width(width.dxp)
                .height(height.dxp)
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            textAlign = TextAlign.Center,
            text = title,
            style = MaterialTheme.typography.bodyLarge.merge(
                TextStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 19.sxp
                )
            )
        )
    }
}