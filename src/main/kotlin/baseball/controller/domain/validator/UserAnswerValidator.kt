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
        require(input == "1" || input == "2") { UserAnswerErrorType.YES_OR_NO }
    }
}