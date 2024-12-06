package baseball.controller

import baseball.controller.domain.UserInteractionController

class BaseballController(
    private val userInteractionController: UserInteractionController = UserInteractionController(),
) {
    fun run() {
        userInteractionController.handleStartGame()
        // 컴퓨터가 숫자 뽑음
        val userInput = userInteractionController.handleUserNumber()
    }
}