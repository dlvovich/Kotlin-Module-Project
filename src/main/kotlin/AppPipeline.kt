import java.util.ArrayDeque

class AppPipeline {
    private val screensStack = ArrayDeque<Screen>()
    private val model = ModelManager()
    private val onExit: () -> Unit = { screensStack.pop() }

    fun start() {
        println("\nПривет!")
        screensStack.push(
            SelectArchiveScreen(
                model.archives,
                onExit = onExit
            )
        )
        startRunLoop()
        println("Всего хорошего! Заходите ещё!")
    }

    private fun startRunLoop() {
        while (screensStack.isEmpty().not()) {
            println("\n---------------------------------------")
            val currentScreen = screensStack.peek()
            when (currentScreen) {
                is SelectArchiveScreen -> {
                    currentScreen.onCreate = { screensStack.push(
                        CreateArchiveScreen(onExit)
                    )}
                    currentScreen.onOpen = { selected ->
                        model.currentArchiveIndex = selected
                        screensStack.push(
                            SelectNoteScreen(
                                model.getNotesForCurrentArchive(),
                                model.currentArchive.title,
                                onExit = onExit,
                            )
                    )}
                }

                is SelectNoteScreen -> {
                    currentScreen.onCreate = { screensStack.push(
                        CreateNoteScreen(
                            onExit = onExit,
                            completion = {
                                currentScreen.entities = model.getNotesForCurrentArchive()
                            }
                        )
                    )}
                    currentScreen.onOpen = { selected ->
                        val note = model.getNote(selected)
                        screensStack.push(
                            ShowNoteScreen(
                                note,
                                onExit = onExit
                            )
                        )
                    }
                }

                is CreateArchiveScreen -> {
                    currentScreen.onAddEntity = { archive: Archive ->
                        model.addArchive(archive)
                    }
                }

                is CreateNoteScreen -> {
                    currentScreen.onAddEntity = { note: Note ->
                        model.addNote(note)
                    }
                }

                is ShowNoteScreen -> {}

                else -> break
            }

            currentScreen.present()
        }
    }
}