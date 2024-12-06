package baseball.controller

import baseball.controller.domain.UserInteractionController
import baseball.controller.domain.validator.UserAnswerValidator
import baseball.controller.domain.validator.UserNumberValidator
import baseball.model.ComputerNumber
import baseball.util.RandomNumber

class BaseballController(
    private val userInteractionController: UserInteractionController = UserInteractionController(),
    private val userNumberValidator: UserNumberValidator = UserNumberValidator(),
    private val userAnswerValidator: UserAnswerValidator = UserAnswerValidator(),
) {
    fun run() {
        var userAnswer = true
        while (userAnswer) {
            var again = true
            userInteractionController.handleStartGame()
            val computerNumbers = getComputerNumbers()
            while (again) {
                val userNumbers = getUserNumber()
                val result = computerNumbers.getGameResult(userNumbers)
                userInteractionController.handleResult(result)
                if (result["strike"] == 3) again = false
            }
            userAnswer = getAgainGame()
        }
    }

    private fun getComputerNumbers(): ComputerNumber {
        val numbers = RandomNumber.getRandomNumber()
        return ComputerNumber(numbers)
    }

    private fun getUserNumber(): List<Int> {
        val userInput = userInteractionController.handleUserNumber()
        userNumberValidator(userInput)
        return userInput.split("").filter { it.isNotEmpty() }.map { it.toInt() }
    }

    private fun getAgainGame(): Boolean {
        val userAnswer = userInteractionController.handleAgainGame()
        userAnswerValidator(userAnswer)
        return userAnswer == "1"
    }
}