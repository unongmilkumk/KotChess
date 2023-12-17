import java.awt.Dimension
import javax.swing.JFrame

fun main(args: Array<String>) {
    val window = JFrame("KotChess")

    window.size = Dimension(800, 800)

    val chessCode = chessCodeToMove()[0] as Pawn
    println(chessCode.goingTo.a + " " + chessCode.goingTo.b)
    println(chessCode.moveCode)
    println(chessCode.isEating)

    window.isVisible = true
}