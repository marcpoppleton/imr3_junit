package enssat.imr.tdd

import java.lang.Exception
import java.util.*

class UneClasse(){

    var unAttribut:String = ""
        set(value) { // je surcharge le setter de mon attribut
            field = value
        }
        get(){ // je surcharge le getter de mon attribut
            return field
        }

    var unAutreAttribut:Int = -1
        private set(value) { // je veux que le setter soit privé et le getter public
            field = value
        }


    var uneAutreDate:Calendar = Calendar.getInstance()

    var uneDate:Calendar = Calendar.getInstance()
    set(value) { // Avant de setter la valeur de mon attribut je veux vérifier une condition préalable
        if (value.before(uneAutreDate)){
                field = value
            }
            else{
            throw Exception()
        }
    }
}