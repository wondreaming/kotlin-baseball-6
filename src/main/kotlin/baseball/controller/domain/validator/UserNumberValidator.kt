package baseball.controller.domain.validator

class UserNumberValidator {
    operator fun invoke(input: String) {
        checkEmpty(input)
        checkInteger(input)
        checkZero(input)
        checkNegativeNumber(input)
        checkLength(input)
        val numbers = input.split("").map { it.toInt() }
        checkDuplicate(numbers)
        check1to9(numbers)
    }

    private fun checkEmpty(input: String) {
        require(input.isNotEmpty()) { UserNumberErrorType.EMPTY_INPUT }
    }

    private fun checkInteger(input: String) {
        requireNotNull(input.toIntOrNull()) { UserNumberErrorType.NOT_INTEGER }
    }

    private fun checkZero(input: String) {
        require(input.toInt() != 0) { UserNumberErrorType.ZERO }
    }

    private fun checkNegativeNumber(input: String) {
        require(input.toInt() > 0) { UserNumberErrorType.NEGATIVE_NUMBER }
    }

    private fun checkLength(input: String) {
        require(input.length == 3) { UserNumberErrorType.LENGTH }
    }

    private fun checkDuplicate(numbers: List<Int>) {
        require(numbers.size == numbers.toSet().size) { UserNumberErrorType.DUPLICATE }
    }

    private fun check1to9(numbers: List<Int>) {
        require(numbers.all { it in 1..9 }) { UserNumberErrorType.OTHER }
    }
}