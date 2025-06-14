package ir.sbpro.aventronix.dailogs

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import ir.sbpro.aventronix.components.AvtDialog
import ir.sbpro.aventronix.resources.AvtImageResources
import ir.sbpro.aventronix.ui.dxp

@Composable
public fun NoNetworkDialog(active: Boolean, onDismiss: () -> Unit) {
    AvtDialog(active = active, onDismiss = onDismiss) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(vertical = 16.dxp, horizontal = 16.dxp)
                .fillMaxWidth()
        ) {
            Image(
                painter = AvtImageResources.rememberImage(AvtImageResources.nonet),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.width(250.dxp)
            )

            Text(
                text = "عدم اتصال به اینترنت",
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(12.dxp),
            )
        }
    }
}