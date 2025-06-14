package ir.sbpro.aventronix.utils

class TimeUtils {
    companion object {
        fun formatRecord(timeMs: Long, separator: String = ":") : String {
            val sec = timeMs / 1000
            val ms = (timeMs % 1000) / 10
            val msStr = if(ms < 10) "0$ms" else ms.toString()
            return "$sec$separator$msStr"
        }

        fun formatTime(timeMs: Long, separator: String = ":", accurate: Boolean = false) : String {
            val hours = timeMs / (3600 * 1000)
            var rem = timeMs % (3600 * 1000)
            val minutes = rem / 60000
            rem = rem % 60000
            val seconds = rem / 1000
            rem = rem % 1000
            val h = rem / 10

            val strBuilder = StringBuilder()
            if(hours > 0){
                if(hours < 10) strBuilder.append("0")
                strBuilder.append(hours)
                strBuilder.append(separator)
            }

            if(minutes < 10) strBuilder.append("0")
            strBuilder.append(minutes)
            strBuilder.append(separator)

            if(seconds < 10) strBuilder.append("0")
            strBuilder.append(seconds)
            if(accurate){
                strBuilder.append(".")
                if(h < 10) strBuilder.append("0")
                strBuilder.append(h)
            }

            return strBuilder.toString()
        }
    }
}