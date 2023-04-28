package com.withcodeplays.ext

import android.os.Build
import android.util.Base64
import android.view.View
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import timber.log.Timber
import java.sql.Timestamp
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun String?.fromISO8601Date(): Date? {
    val var1: TimeZone = TimeZone.getTimeZone("UTC")
    val var2: DateFormat =
        SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'") as DateFormat
    var2.timeZone = var1
    return try {
        var2.parse(this ?: "")
    } catch (var3: ParseException) {
        Timber.e("TAG", "fromISO8601Date: $this")
        var3.printStackTrace()
        null
    }
    //8
}

fun Date?.getTimeInMillious():Long?
{
    return this?.time
}

fun String.fromISODashBoardCreatedDate():String
{
    return try {
        val timeNormal = Timestamp.valueOf(this).time
        SimpleDateFormat("MMMM dd,yyyy @ hh:mm:a", Locale.ENGLISH).format(timeNormal)
    } catch (var3: ParseException) {
        Timber.e("TAG", "fromISO8601Date: $this")
        var3.printStackTrace()
        ""
    }
}


@RequiresApi(Build.VERSION_CODES.O)
fun String?.fromISODahsbordDate(): String? {
    return try {
        //val var1: TimeZone = TimeZone.getTimeZone("UTC")
        val cal = Calendar.getInstance()
        val var1: TimeZone = TimeZone.getTimeZone(cal.timeZone.toZoneId())
        val var2: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.ENGLISH) as DateFormat
        var2.timeZone = var1
        val oldDate = var2.parse(this ?: "")
        val newSdf = SimpleDateFormat("MMMM dd,yyyy @ hh:mm:a", Locale.ENGLISH)
        newSdf.format(oldDate)
    } catch (var3: ParseException) {
        Timber.e("TAG", "fromISO8601Date: $this")
        var3.printStackTrace()
        this
    }
    //8
}
fun <T> List<T>.toArrayList(): ArrayList<T> {
    return ArrayList(this)
}


fun String.toDate(): Date {
    return SimpleDateFormat("dd/MM/yyyy", Locale.US).parse(this) ?: Date()
}


fun String.getBase64(input: String): String? {
   return Base64.encodeToString(
        input.toByteArray(),
        Base64.NO_WRAP
    )
}


fun View.gone()
{
    this.visibility =View.GONE
}

@RequiresApi(Build.VERSION_CODES.O)
fun String?.fromISO8601TrialEndDate(): Date? {
    val cal = Calendar.getInstance()
    val var1: TimeZone = TimeZone.getTimeZone(cal.timeZone.toZoneId())
    Timber.d("TAG", "fromISO8601TrialEndDate: $var1")
    val var2: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'") as DateFormat
    var2.timeZone = var1
    return try {
        var2.parse(this ?: "")
    } catch (var3: ParseException) {
        Timber.e("TAG", "fromISO8601Date: $this")
        var3.printStackTrace()
        null
    }
    //8

}

fun RecyclerView?.getCurrentPosition() : Int {
    return (this?.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
}

