class SelectNoteScreen(
    override var entities: List<Entity>,
    private val archiveTitle: String,
    onExit: () -> Unit
): SelectorScreen(onExit = onExit) {
    override val entityName = "заметку"
    override val entityNameGenitive = "заметок"

    override fun present() {
        println("Список $entityNameGenitive в разделе $archiveTitle:")
        super.present()
    }
}