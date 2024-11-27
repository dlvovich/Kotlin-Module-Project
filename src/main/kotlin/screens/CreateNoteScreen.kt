class CreateNoteScreen(
    onExit: () -> Unit,
    val completion: () -> Unit
): CreatorScreen<Note>(onExit = onExit) {

    override fun handleInput() {
        val inputManager = TextInputManager(TextAddEntityDescription.NOTETITLE)
        val noteTitle = inputManager.getInput()

        inputManager.entityDescription = TextAddEntityDescription.NOTEBODY
        val noteBody = inputManager.getInput()

        onAddEntity?.let { it(Note(noteTitle, noteBody)) }
        println("Заметка $noteTitle успешно создана")
        onExit()
        completion()
    }
}