package enssat.imr.tdd

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.isA
import org.hamcrest.Matchers.greaterThan
import org.hamcrest.Matchers.matchesPattern
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import java.util.*

class ExerciceUnitTest{

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
    fun test_types(){
        assertThat(employee.ID, isA(Int::class.java))
        assertThat(employee.surname, isA(String::class.java))
        assertThat(employee.name, isA(String::class.java))
        assertThat(employee.dateOfBirth, isA(Calendar::class.java))
        assertThat(employee.dateOfHire, isA(Calendar::class.java))
    }

    @Test
    fun test_typo(){
        assertThat(employee.surname, matchesPattern("[A-Z]{1}\\w*"))
        assertThat(employee.name, matchesPattern("[A-Z]{1}\\w*"))
    }

    @Test
    fun test_positive(){
        assertThat(employee.getAge(), `is`(greaterThan(0)))
        assertThat(employee.getExperience(), `is`(greaterThan(0)))
    }

    @Test
    fun test_order(){
        assertThat(employee.dateOfHire, `is`(greaterThan(employee.dateOfBirth)))
    }

    @Test(expected = TimeTravellerException::class)
    fun test_timeTravellerException(){
        val now = Calendar.getInstance()
        val dob_in_future = Calendar.getInstance()
        dob_in_future.set(now.get(Calendar.YEAR) + 100,now.get(Calendar.MONTH),now.get(Calendar.DATE))
        employee.dateOfBirth = dob_in_future
    }

    @Test(expected = FoldingTimeException::class)
    fun test_FoldingTimeException(){
        val dob = employee.dateOfBirth
        val doh_in_past = Calendar.getInstance()
        doh_in_past.set(dob.get(Calendar.YEAR) - 100,dob.get(Calendar.MONTH),dob.get(Calendar.DATE))
        employee.dateOfHire = doh_in_past
    }
}