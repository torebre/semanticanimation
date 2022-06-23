import kotlin.test.Test
import kotlin.test.assertEquals

class RegularExpressionTest {


    @Test
    fun testRegularExpression() {
        RegularExpression.parseExpression("a*aa", "aaabbaaa")

    }


}