abstract class CreatorScreen<T: Entity>(
    onExit: () -> Unit
): Screen(onExit) {
    var onAddEntity: ((entity: T) -> Unit)? = null

    override fun present() {
        handleInput()
    }
}