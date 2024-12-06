package baseball.model

data class ComputerNumber(
    private val numbers: List<Int>,
) {
    fun getGameResult(userNumbers: List<Int>): Map<String, Int> {
        val strike = checkStrike(userNumbers)
        val ball = checkBall(userNumbers, strike)
        val result = mapOf("strike" to strike, "ball" to ball)
        return result
    }

    private fun checkStrike(userNumbers: List<Int>): Int {
        var strike = 0
        for (i in 0..2) {
            if (numbers[i] == userNumbers[i]) strike++
        }
        return strike
    }

    private fun checkBall(userNumbers: List<Int>, strike: Int): Int {
        val ball = numbers.intersect(userNumbers).size - strike
        return ball
    }
}
