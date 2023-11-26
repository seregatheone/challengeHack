package pat.project.challengehack.screens.library

import androidx.lifecycle.ViewModel
import basic.domain.library.models.LibraryEntity
import basic.domain.main.models.GenreEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LibraryViewModel @Inject constructor(

) : ViewModel() {
    val localSoundList = listOf<LibraryEntity>(
        LibraryEntity("Can i", "Drake", ""),
        LibraryEntity("Can i", "Drake", ""),
        LibraryEntity("Can i", "Drake", ""),
        LibraryEntity("Can i", "Drake", ""),
        LibraryEntity("Can i", "Drake", ""),
        LibraryEntity("Can i", "Drake", ""),
        LibraryEntity("Can i", "Drake", ""),
        LibraryEntity("Can i", "Drake", ""),
        LibraryEntity("Can i", "Drake", ""),
        LibraryEntity("Can i", "Drake", ""),
        LibraryEntity("Can i", "Drake", ""),
    )
}