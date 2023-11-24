package core.ui.components.buttons.iconButton

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.GroupAdd
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.MicOff
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.ui.graphics.vector.ImageVector

enum class IconButtonStyles(
    val icon : ImageVector
) {
    ARROW_BACK(Icons.Default.ArrowBack),
    EXIT(Icons.Default.Close),
    GROUP_ADD(Icons.Default.GroupAdd),
    GROUP(Icons.Default.Group),
    MORE(Icons.Default.MoreVert),
    SYNC(Icons.Default.Contacts),
    PHONE(Icons.Default.Phone),
    CALL(Icons.Default.MoreHoriz),
    MICOFF(Icons.Default.MicOff),
    MIC(Icons.Default.Mic),
    VOLUME(Icons.Default.VolumeUp),
    MESSAGE(Icons.Default.Message),
    MENU(Icons.Default.Menu),
    ADD(Icons.Default.Add),
    PERSON(Icons.Default.Person)
}