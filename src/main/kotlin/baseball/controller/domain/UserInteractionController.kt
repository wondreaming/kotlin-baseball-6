package baseball.controller.domain

import baseball.constant.Constants
import baseball.constant.Game
import baseball.view.InputView
import baseball.view.OutputView

class UserInteractionController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(),
) {
    fun handleStartGame() {
        outputView.showMsg("숫자 야구 게임을 시작합니다.")
    }

    fun handleUserNumber(): String {
        outputView.showMsg2("숫자를 입력해주세요 : ")
        return inputView.getInput()
    }

    fun handleResult(result: Map<Constants, Int>) {
        val strike = result[Constants.STRIKE]
        val ball = result[Constants.BALL]
        if (strike == Game.ZERO.getValue() && ball == Game.ZERO.getValue()) {
            outputView.showMsg("낫싱")
            return
        }
        if (ball == Game.ZERO.getValue()) {
            outputView.showMsg("${strike}스트라이크")
            if (strike == Game.END_STRIKE.getValue()) outputView.showMsg("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            return
        }
        if (strike == Game.ZERO.getValue()) {
            outputView.showMsg("${ball}볼")
            return
        }
        outputView.showMsg("${ball}볼 ${strike}스트라이크")
    }

    fun handleAgainGame(): String {
        outputView.showMsg("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        return inputView.getInput()
    }
}