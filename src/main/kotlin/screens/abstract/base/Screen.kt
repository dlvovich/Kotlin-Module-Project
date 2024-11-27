sealed class Screen(
    protected val onExit: () -> Unit
) {
    abstract fun present()
    protected abstract fun handleInput()
}