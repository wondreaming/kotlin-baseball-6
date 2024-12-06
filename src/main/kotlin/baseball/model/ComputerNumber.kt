package baseball.model

import baseball.constant.Constants
import baseball.constant.Game

data class ComputerNumber(
    private val numbers: List<Int>,
) {
    fun getGameResult(userNumbers: List<Int>): Map<Constants, Int> {
        val strike = checkStrike(userNumbers)
        val ball = checkBall(userNumbers, strike)
        val result = mapOf(Constants.STRIKE to strike, Constants.BALL to ball)
        return result
    }

    private fun checkStrike(userNumbers: List<Int>): Int {
        var strike = Game.ZERO.getValue()
        for (i in Game.ZERO.getValue()..Game.TWO.getValue()) {
            if (numbers[i] == userNumbers[i]) strike++
        }
        return strike
    }

    private fun checkBall(userNumbers: List<Int>, strike: Int): Int {
        val ball = numbers.intersect(userNumbers.toSet()).size - strike
        return ball
    }
}
