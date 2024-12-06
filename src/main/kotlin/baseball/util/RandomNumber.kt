package baseball.util

import baseball.constant.Game
import camp.nextstep.edu.missionutils.Randoms

object RandomNumber {
    fun getRandomNumber(): List<Int> {
        val computer = mutableListOf<Int>()
        while (computer.size < Game.NUMBER_SIZE.getValue()) {
            val randomNumber = Randoms.pickNumberInRange(Game.START_NUMBER.getValue(), Game.END_NUMBER.getValue())
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        return computer
    }
}