package baseball.controller.domain

import InputView
import OutputView

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

    fun handleResult(result: Map<String, Int>) {
        val strike = result["strike"]
        val ball = result["ball"]
        if (strike == 0 && ball == 0) {
            outputView.showMsg("낫싱")
            return
        }
        if (ball == 0) {
            outputView.showMsg("${strike}스트라이크")
            if (strike == 3) outputView.showMsg("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            return
        }
        if (strike == 0) {
            outputView.showMsg("${ball}볼")
            return
        }
        outputView.showMsg("${ball}볼 ${strike}스트라이크")
    }
}