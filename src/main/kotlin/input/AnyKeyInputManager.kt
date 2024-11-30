class AnyKeyInputManager: InputManager<Unit> {
    override fun getInput() {
        System.`in`.read()
    }
}