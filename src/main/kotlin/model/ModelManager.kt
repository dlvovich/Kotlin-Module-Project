import java.util.ArrayList

class ModelManager {
    private var _archives = ArrayList<Archive>()
    private val notes: MutableMap<Archive, MutableList<Note>> = mutableMapOf()

    val archives: List<Archive>
        get() = _archives

    val currentArchive: Archive
        get() = _archives[currentArchiveIndex]

    var currentArchiveIndex = 0

    fun addArchive(archive: Archive) {
        _archives.add(archive)
    }

    fun addNote(note: Note) {
        val currentArchive = _archives[currentArchiveIndex]
        val notesList = notes[currentArchive] ?: mutableListOf()
        notesList.add(note)
        notes[currentArchive] = notesList
    }

    fun getNotesForCurrentArchive(): List<Note> {
        val currentArchive = _archives[currentArchiveIndex]
        return notes[currentArchive] ?: listOf()
    }

    fun getNote(index: Int): Note {
        val currentArchive = _archives[currentArchiveIndex]
        val notes = this.notes[currentArchive]
        return notes?.get(index) ?: Note(
            "Ошибка!",
            "Произошло невероятное, заметки тут нет. Срочно сообщите разработчику."
        )
    }
}