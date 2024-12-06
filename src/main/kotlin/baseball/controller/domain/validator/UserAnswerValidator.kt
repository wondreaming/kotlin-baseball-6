package baseball.controller.domain.validator

class UserAnswerValidator {
    operator fun invoke(input: String) {
        checkEmpty(input)
        checkYesOrNo(input)
    }

    private fun checkEmpty(input: String) {
        require(input.isNotEmpty()) { UserAnswerErrorType.EMPTY_INPUT }
    }

    private fun checkYesOrNo(input: String) {
        require(input == GAME_AGAIN_ANSWER || input == GAME_STOP_ANSWER) { UserAnswerErrorType.YES_OR_NO }
    }

    companion object {
        private const val GAME_AGAIN_ANSWER = "1"
        private const val GAME_STOP_ANSWER = "2"
    }
}