import com.kjipo.regex.RegularExpression
import mu.KotlinLogging
import mu.KotlinLoggingConfiguration
import mu.KotlinLoggingLevel

val logger = KotlinLogging.logger {}

fun main() {
    KotlinLoggingConfiguration.LOG_LEVEL = KotlinLoggingLevel.DEBUG

    val regularExpression = RegularExpression()
    val result = regularExpression.doMatch("a+", "a")
//    println("Result: ${result}")

    CharacterSequence("Test", "regexp_visualization")

    val stackVisualization = StackVisualization(regularExpression.actionSequence, "stack_visualization")
    stackVisualization.runActionScript()

}