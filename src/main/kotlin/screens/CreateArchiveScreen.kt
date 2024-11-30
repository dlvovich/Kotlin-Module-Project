class CreateArchiveScreen(
    onExit: () -> Unit
): CreatorScreen<Archive>(onExit = onExit) {

    override fun handleInput() {
        val inputManager = TextInputManager(TextAddEntityDescription.ARCHIVE)
        val inputTitle = inputManager.getInput()
        onAddEntity?.let { it(Archive(inputTitle)) }
        println("Архив $inputTitle успешно создан")
        onExit()
    }
}