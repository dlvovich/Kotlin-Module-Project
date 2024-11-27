class CommandInputManager(
    private val possibleValues: ClosedRange<Int>
): InputManager<Int> {
    override fun getInput(): Int {
        println("\nВведите команду:")
        var command: Int? = null
        while (command == null) {
            val input = readLine()?.trim()?.toIntOrNull()
            if (input != null && input in possibleValues) {
                command = input
            } else {
                println("Некорректная команда. Необходимо число от ${possibleValues.start} до ${possibleValues.endInclusive}")
                println("Попробуйте ещё раз")
            }
        }

        return command
    }
}