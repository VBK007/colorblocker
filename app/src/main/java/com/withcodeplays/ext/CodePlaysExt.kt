package com.withcodeplays.ext

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.withcodeplays.BaseApp
import kotlin.random.Random

fun Context.toast(message: String?) {
    if (!message.isNullOrEmpty()) Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Context.toast(id: Int) {
    Toast.makeText(this, this.getString(id), Toast.LENGTH_LONG).show()
}

fun Fragment.toast(id: Int) {
    Toast.makeText(this.requireActivity(), this.getString(id), Toast.LENGTH_LONG).show()
}

fun Fragment.toast(message: String?) {
    if (!message.isNullOrEmpty()) Toast.makeText(this.requireActivity(), message, Toast.LENGTH_LONG)
        .show()
}

fun View.showOrhide(isTrue: Boolean) {
    if (isTrue) {
        this.visibility = View.VISIBLE
    } else {
        this.visibility = View.GONE
    }
}

inline fun Context.longToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun HashMap<String, String>.getRandom(): Pair<String, String> {
    val map = this
    val keysAsArray: List<String> = ArrayList<String>(map.keys)
    val Result = Random.nextInt(0, map.size)
    val randomKey = map[keysAsArray[Result]] ?: ""
    return Pair(randomKey, map[randomKey] ?: "")
}
inline fun getColorCompat(resId: Int) = ContextCompat.getColor(BaseApp.instance, resId)


fun Context.isPackageExist(context: Context, target: String): Boolean {
    return context.packageManager.getInstalledApplications(0).find { info -> info.packageName == target } != null
}

inline fun dpToPx(dp: Float): Int {
    return dpToPx(dp, BaseApp.instance.resources)
}
 fun dpToPx(dp: Float, resources: Resources): Int {
    val px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics)
    return px.toInt()
}

inline fun View.show() {
    visibility = View.VISIBLE
}

inline fun View.hide() {
    visibility = View.GONE
}

inline fun ViewGroup.show() {
    visibility = View.VISIBLE
}

fun View.showWithAnim() {
    //if (!isVisible) {
    this.animate().alpha(1F).setDuration(450L).start()
    //}
}

fun View.hideWithAnim() {
    this.animate().alpha(0F).setDuration(450L).start()
}

fun View.hideWithDelay(time: Long = 600) {
    postDelayed({
        this.hideWithAnim()
    }, time)
}

fun ViewGroup.hide(view: Int = View.GONE) {
    visibility = view
}

inline fun ImageView.loadImage(url: String) {
    Glide.with(context).load(url).into(this)
}