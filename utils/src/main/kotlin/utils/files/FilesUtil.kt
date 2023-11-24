package utils.files

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Environment
import android.util.Log
import androidx.core.content.FileProvider
import java.io.File


object FilesUtil {
    const val MAX_SIZE_IMAGE_MB = 10

    private fun getFilesCacheDir(context: Context): File {
        val cacheFiles = File(context.cacheDir, "files")
        cacheFiles.mkdir()
        return cacheFiles
    }

    private const val FILE_PREFIX = "selected_image_"
    private const val FILE_SUFFIX = ".jpg"
    fun getImageUri(context: Context): Uri {
        val directory = getFilesCacheDir(context)
        val file = File.createTempFile(
            FILE_PREFIX,
            FILE_SUFFIX,
            directory,
        )
        return FileProvider.getUriForFile(
            context,
            "${context.packageName}.fileprovider",
            file,
        ).apply {
            Log.d(FilesUtil::class.java.name,"$this")
        }
    }
}