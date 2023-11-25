package utils.fileprovider

import android.content.Context
import android.net.Uri
import androidx.core.content.FileProvider
import pat.project.challengehack.utils.R
import java.io.File

class ComposeFileProvider : FileProvider(R.xml.file_paths) {

//    fun getAudioFile(): Uri {
//        return
//    }
//
//    fun cacheAudioFile() {
//
//    }

    companion object {
        private const val AUTHORITY = "me.app.advocall.agent.fileprovider"
        private const val DIRECTORY_CHILD_IMAGES = "images"
        private const val FILE_PREFIX = "selected_image_"
        private const val FILE_SUFFIX = ".jpg"


        fun getImageUri(context: Context): Uri {
            val directory = File(context.cacheDir, DIRECTORY_CHILD_IMAGES)
            directory.mkdirs()
            val file = File.createTempFile(
                FILE_PREFIX,
                FILE_SUFFIX,
                directory,
            )
            return getUriForFile(
                context,
                AUTHORITY,
                file,
            )
        }
    }
}