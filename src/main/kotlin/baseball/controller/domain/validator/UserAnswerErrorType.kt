package baseball.controller.domain.validator

enum class UserAnswerErrorType (
    private val errorMessage: String
) {
    EMPTY_INPUT("빈 문자를 입력했습니다."),
    YES_OR_NO("1과 2만 입력해주세요.");

    override fun toString(): String = "$ERROR $errorMessage"

    companion object {
        private const val ERROR = "[ERROR]"
    }
}