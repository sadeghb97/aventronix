package ir.sbpro.aventronix.components

import android.app.Activity
import android.content.pm.PackageManager
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import ir.sbpro.aventronix.ui.dxp

@Composable
public fun AboutUsDialog(
    activity: Activity,
    packageName: String,
    active: Boolean,
    animationVisible: Boolean,
    logoPainter: Painter,
    appPainter: Painter,
    appName: String,
    onDismiss: () -> Unit
) {
    val info = activity.packageManager.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES)
    val verName = info.versionName
    val verCode = info.versionCode

    AvtDialog(active = active, onDismiss = onDismiss) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(vertical = 16.dxp, horizontal = 16.dxp)
                .fillMaxWidth()
        ) {
            Image(
                painter = logoPainter,
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.width(270.dxp)
            )

            Column (
                modifier = Modifier.height(227.dxp).width(270.dxp)
            ) {
                AnimatedVisibility(
                    visible = animationVisible,
                    enter = fadeIn(animationSpec = tween(2000))
                ) {
                    Image(
                        painter = appPainter,
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .padding(top = 16.dxp).fillMaxSize()
                    )
                }
            }

            Text(
                text = appName,
                modifier = Modifier.padding(12.dxp),
            )
            Text(
                text = "نسخه " + "$verName ($verCode)"
            )
        }
    }
}