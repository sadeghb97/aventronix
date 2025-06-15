package ir.sbpro.aventronix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import ir.sbpro.aventronix.resources.AvtImageResources
import ir.sbpro.aventronix.system.TransparentNavigationBar
import ir.sbpro.aventronix.ui.SizeInterface
import ir.sbpro.aventronix.ui.dxp
import ir.sbpro.aventronix.ui.theme.AventronixTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val avnAnimationVisible = remember { mutableStateOf(false) }

            TransparentNavigationBar()
            SizeInterface.ExtendScreenSize()

            LaunchedEffect(Unit) {
                delay(1000)
                avnAnimationVisible.value = true
            }

            AventronixTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(Color(0xFFB388FF), Color(0xFF8C9EFF))
                                )
                            )
                            .padding(bottom = 45.dxp)
                    ) {
                        Column(modifier = Modifier
                            .align(Alignment.Center)
                            .padding(top = 8.dxp)
                            .fillMaxWidth()
                            .padding(16.dxp)) {

                            AnimatedVisibility(
                                visible = avnAnimationVisible.value,
                                enter = fadeIn(animationSpec = tween(2000))
                            ) {
                                Image(
                                    painter = AvtImageResources.rememberImage(R.drawable.aventronix),
                                    contentDescription = null,
                                    contentScale = ContentScale.FillWidth,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(16.dxp))
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
