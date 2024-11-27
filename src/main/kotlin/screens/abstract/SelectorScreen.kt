abstract class SelectorScreen(
    onExit: () -> Unit
): Screen(onExit) {
    var onCreate: (() -> Unit)? = null
    var onOpen: ((selected: Int) -> Unit)? = null

    abstract val entities: List<Entity>
    abstract val entityName: String
    abstract val entityNameGenitive: String

    private val commandNumsStart = 0
    private val commandNumsEnd: Int
        get() = entities.size + 1

    override fun present() {
        for (commandNum in commandNumsStart..commandNumsEnd) {
            when (commandNum) {
                commandNumsStart -> println("${commandNum}. Создать $entityName")
                commandNumsEnd -> println("${commandNum}. Выход")
                else -> println("${commandNum}. ${entities[commandNum - 1].title}")
            }
        }

        handleInput()
    }

    override fun handleInput() {
        val inputManager = CommandInputManager(
            commandNumsStart..commandNumsEnd
        )

        val command = inputManager.getInput()
        when (command) {
            commandNumsStart -> onCreate?.let { it() }
            commandNumsEnd -> onExit()
            else -> onOpen?.let { it(command - 1) }
        }
    }
}