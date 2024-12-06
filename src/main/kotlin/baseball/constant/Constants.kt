package baseball.constant

enum class Constants(private val value: String) {
    STRIKE("strike"),
    BALL("ball");

    override fun toString(): String = value
}