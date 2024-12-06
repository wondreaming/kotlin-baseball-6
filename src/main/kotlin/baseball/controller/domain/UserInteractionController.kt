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
}