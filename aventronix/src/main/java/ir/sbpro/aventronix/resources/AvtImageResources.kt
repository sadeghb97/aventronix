package ir.sbpro.aventronix.resources

import android.content.Context
import android.os.Build
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.ImageLoader
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.imageLoader
import coil.request.ImageRequest
import coil.size.Size
import ir.sbpro.aventronix.R

class AvtImageResources (val context: Context){
    companion object {
        val gem: Int = R.drawable.gem
        val nonet: Int = R.drawable.nonet
        val translate: Int = R.drawable.ic_translate
        val ic_gmail: Int = R.drawable.ic_gmail
        val ic_telegram: Int = R.drawable.ic_telegram
        val ic_instagram: Int = R.drawable.ic_instagram

        @Composable
        public fun rememberFastImage(resId: Int) : AsyncImagePainter {
            return rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current)
                    .data(data = resId)
                    .size(Size.ORIGINAL)
                    .crossfade(true)
                    .build(),
                imageLoader = LocalContext.current.imageLoader,
            )
        }

        @Composable
        public fun rememberGIF(resId: Int) : AsyncImagePainter {
            val context = LocalContext.current
            val imageLoader = ImageLoader.Builder(context)
                .components {
                    if (Build.VERSION.SDK_INT >= 28) {
                        add(ImageDecoderDecoder.Factory())
                    } else {
                        add(GifDecoder.Factory())
                    }
                }
                .build()

            return rememberAsyncImagePainter(
                ImageRequest.Builder(context)
                    .data(data = resId)
                    .size(Size.ORIGINAL)
                    .crossfade(true)
                    .build(),
                imageLoader = imageLoader,
            )
        }

        @Composable
        public fun rememberImage(resId: Int) : Painter {
            return if(!lightBuild()) painterResource(resId)
            else rememberFastImage(resId)
        }

        fun lightBuild() : Boolean {
            return Build.VERSION.SDK_INT < 24
        }

        @Composable
        public fun rememberGem() : Painter {
            return if(!lightBuild()) painterResource(gem)
            else rememberFastImage(gem)
        }
    }
}