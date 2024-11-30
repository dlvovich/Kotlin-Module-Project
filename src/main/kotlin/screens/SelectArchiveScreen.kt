class SelectArchiveScreen(
    override val entities: List<Entity>,
    onExit: () -> Unit
): SelectorScreen(onExit = onExit) {
    override val entityName = "архив"
    override val entityNameGenitive = "архивов"

    override fun present() {
        println("Список $entityNameGenitive:")
        super.present()
    }
}