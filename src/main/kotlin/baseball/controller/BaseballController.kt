package baseball.controller

import baseball.controller.domain.UserInteractionController
import baseball.controller.domain.validator.UserNumberValidator

class BaseballController(
    private val userInteractionController: UserInteractionController = UserInteractionController(),
    private val userNumberValidator: UserNumberValidator = UserNumberValidator(),
) {
    fun run() {
        userInteractionController.handleStartGame()
        // 컴퓨터가 숫자 뽑음
        val userNumber = getUserNumber()
    }

    private fun getUserNumber(): List<Int> {
        val userInput = userInteractionController.handleUserNumber()
        userNumberValidator(userInput)
        return userInput.split("").map { it.toInt() }
    }
}