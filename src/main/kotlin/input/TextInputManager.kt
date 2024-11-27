class TextInputManager(
    var entityDescription: TextAddEntityDescription
): InputManager<String> {
    private val entityName: String
        get() = entityDescription.description

    override fun getInput(): String {
        println("\nВведите $entityName:")
        var content: String? = null
        while (content == null) {
            val input = readLine()?.trim()
            if (input != null && input.isEmpty().not()) {
                content = input
            } else {
                println("${entityName.capitalize()} не может быть пустым")
                println("Попробуйте ещё раз")
            }
        }

        return content
    }
}