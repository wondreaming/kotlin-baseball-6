package baseball.constant

enum class Game(private val value: Int) {
    NUMBER_SIZE(3),
    START_NUMBER(1),
    END_NUMBER(9),
    ZERO(0),
    TWO(2),
    END_STRIKE(3);

    fun getValue(): Int = value
}