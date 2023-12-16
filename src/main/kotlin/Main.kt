import java.awt.Dimension
import javax.swing.JFrame

fun main(args: Array<String>) {
    val window = JFrame("KotChess")

    window.size = Dimension(800, 800)

    window.isVisible = true
}