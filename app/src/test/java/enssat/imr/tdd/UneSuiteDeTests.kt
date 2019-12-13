package enssat.imr.tdd



import org.hamcrest.Matchers.matchesPattern
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import java.util.*

class UneSuiteDeTests {

    lateinit var employee:Employee

    @Before
    fun prepare(){
        val dob = Calendar.getInstance()
        dob.set(1977,7,16)
        val doh = Calendar.getInstance()
        doh.set(2001,9,11)
        employee = Employee(1,"Marc","Poppleton")
        employee.dateOfBirth = dob
        employee.dateOfHire = doh
    }

    @Test
    fun test_typo() {
        assertThat(employee.surname, matchesPattern("[A-Z]{1}\\w*"))
        assertThat(employee.name, matchesPattern("[A-Z]{1}\\w*"))
    }
}