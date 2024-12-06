package baseball.controller.domain.validator

enum class UserNumberErrorType(
    private val errorMessage: String
) {
    EMPTY_INPUT("빈 문자를 입력했습니다."),
    NOT_INTEGER("long 타입의 숫자나 문자 타입을 입력했습니다."),
    ZERO("0을 입력했습니다."),
    NEGATIVE_NUMBER("음수를 입력했습니다."),
    OTHER("각 자리의 수는 1 ~9 사이의 숫자로만 이루어져야합니다."),
    DUPLICATE("같은 숫자가 들어왔습니다."),
    LENGTH("3자리 숫자만 가능합니다.");


    override fun toString(): String = "$ERROR $errorMessage"

    companion object {
        private const val ERROR = "[ERROR]"
    }
}