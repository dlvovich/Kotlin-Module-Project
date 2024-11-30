class ShowNoteScreen(
    private val note: Note,
    onExit: () -> Unit
): Screen(onExit = onExit) {
    override fun present() {
        println("Содержимое заметки \"${note.title}\":")
        println("${note.body}\n")
        println("Нажмите любую клавишу чтобы вернуться на предыдущий экран...")
        handleInput()
    }

    override fun handleInput() {
        AnyKeyInputManager().getInput()
        onExit()
    }
}