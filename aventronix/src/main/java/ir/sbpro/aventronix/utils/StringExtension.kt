package ir.sbpro.aventronix.utils

fun String?.safeLong(uk: Long = 0, escapeZero: Boolean = false) : Long {
    return if(isNullOrEmpty()) uk
    else if(escapeZero && equals("0")) uk
    else {
        try {
            this.toLong()
        } catch (ex: Exception){
            val d: Double = this.safeDouble()
            if(d > 0) d.toLong()
            else uk
        }
    }
}

fun String?.safeInt(uk: Long = 0, escapeZero: Boolean = false) : Int {
    return this.safeLong(uk, escapeZero).toInt();
}

fun String?.safeDouble(uk: Double = 0.0, escapeZero: Boolean = false) : Double {
    return if(isNullOrEmpty()) uk
    else if(escapeZero && (equals("0") || equals("0.0"))) uk
    else {
        try {
            this.toDouble()
        } catch (ex: Exception){
            uk
        }
    }
}

fun String?.safeBoolean() : Boolean {
    if(safeInt(0) != 0) return true
    return if(isNullOrEmpty()) false
    else {
        try {
            this.toBoolean()
        } catch (ex: Exception){
            false
        }
    }
}