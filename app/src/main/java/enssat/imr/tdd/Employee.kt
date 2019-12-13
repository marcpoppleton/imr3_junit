package enssat.imr.tdd

import java.util.*

class Employee(val ID: Int, val surname: String, val name: String) {

    var dateOfBirth: Calendar = Calendar.getInstance()
        set(dob) {
            val now = Calendar.getInstance()
            if (dob.after(now)) {
                throw TimeTravellerException("Marty what year is it?")
            } else {
                field = dob
            }
        }

    var dateOfHire: Calendar = Calendar.getInstance()
        set(doh) {
            val now = Calendar.getInstance()
            if (doh.after(now)) {
                throw TimeTravellerException("Marty what year is it?")
            }else if (doh.before(dateOfBirth)) {
                throw FoldingTimeException("Marty what year is it?")
            } else {
                field = doh
            }
        }

    fun getAge(): Int? = dateOfBirth?.let {
        Calendar.getInstance().get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR)
    }

    fun getExperience(): Int? = dateOfHire?.let {
        Calendar.getInstance().get(Calendar.YEAR) - dateOfHire.get(Calendar.YEAR)
    }

}

class TimeTravellerException(message: String) : Exception(message)
class FoldingTimeException(message: String) : Exception(message)