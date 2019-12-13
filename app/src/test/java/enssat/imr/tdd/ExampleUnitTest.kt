package enssat.imr.tdd

import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.hasSize
import org.hamcrest.Matchers.matchesPattern
import org.junit.Before
import org.junit.Test

class UnitTestSuite {

    lateinit var list:Collection<String>
    var stuff:String = "Not null"

    @Before<>
    fun prepare(){
        list = listOf("word","another word","yet another word")
    }

    @Test
    fun a_test() {
        assertThat(list,
            allOf(
                hasSize(3),
                everyItem(
                    allOf(
                    containsString("word"),
                    matchesPattern("([a-z]+\\s?)*")
                    )
                )
            ))
    }

    @Test(expected = ArithmeticException::class)
    fun another_test() {
        val number = 4
        val denominator = 0
        number / denominator
    }
}


