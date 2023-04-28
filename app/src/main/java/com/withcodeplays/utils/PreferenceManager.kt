package com.withcodeplays.familytracker.di

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.provider.Settings
import android.provider.Settings.Secure.ANDROID_ID
import com.google.gson.Gson
import javax.inject.Inject
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class PreferenceManager @Inject constructor(var context: Context) {

    private val PREFS_NAME = "SharedPreferenceFamily"
    private var preferences: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    var isUserFirstTime:Boolean
        get() = preferences.getBoolean(KEY_ADD_UNIT_DASHBOARD, true)
        set(isDemo) {
            val editor = preferences!!.edit()
            editor.putBoolean(KEY_ADD_UNIT_DASHBOARD, isDemo)
            editor.apply()
        }

    var selectedLanguage: String
        get() = preferences!!.getString(KEY_LANGUAGE, "en")!!
        set(value) {
            val editor = preferences!!.edit()
            editor.putString(KEY_LANGUAGE, value)
            editor.apply()
        }





    companion object {
        const val USER_ID = "userID"
        const val IS_ADDED = "isAdded"
        const val COUNTRY_USER = "COUNTRY_USER"
        const val FIREBASE_TOKEN = "firebaseID"
        const val AUTH_TOKEN = "authToken"
        const val USER_DETAILS = "user_details"
        const val USER_NEW_RECORDS = "user_user_records"
        const val IS_DEMO = "isDemo"
        const val NO_OF_TIME_OPENED = "NO_OF_TIME_OPENED"
        const val IS_NEW_USER=""
        const val IS_RATING_GIVE="IS_RATING_GIVE"
        const val KEY_ISDEMO="KEY_ISDEMO"
        const val KEY_SHOWADD="KEY_SHOWADD"
        const val KEY_APP_LIVE="KEY_APP_LIVE"
        const val KEY_IS_TRACKING="KEY_IS_TRACKING"
        const val KEY_LANGUAGE="KEY_LANGUAGE"
        const val KEY_ADD_UNIT_DASHBOARD="KEY_ADD_UNIT_DASHBOARD"
        const val KEY_ADD_UNIT_CONTACT="KEY_ADD_UNIT_CONTACT"
        const val KEY_ADD_UNIT_FILTER="KEY_ADD_UNIT_FILTER"
        const val KEY_ADD_UNIT_COMPARE="KEY_ADD_UNIT_COMPARE"
    }
}


/**
 * SharedPreferences extension function, to listen the edit() and apply() fun calls
 * on every SharedPreferences operation.
 */
private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
    val editor = this.edit()
    operation(editor)
    editor.apply()
}

/**
 * puts a key value pair in shared prefs if doesn't exists, otherwise updates value on given [key]
 */
private operator fun SharedPreferences.set(key: String, value: Any?) {
    when (value) {
        is String? -> edit { it.putString(key, value) }
        is Int -> edit { it.putInt(key, value) }
        is Boolean -> edit { it.putBoolean(key, value) }
        is Float -> edit { it.putFloat(key, value) }
        is Long -> edit { it.putLong(key, value) }
        else -> throw UnsupportedOperationException("Not yet implemented")
    }
}

/**
 * finds value on given key.
 * [T] is the type of value
 * @param defaultValue optional default value - will take null for strings, false for bool and -1 for numeric values if [defaultValue] is not specified
 */
private inline operator fun <reified T : Any> SharedPreferences.get(
    key: String,
    defaultValue: T? = null
): T? {
    return when (T::class) {
        String::class -> getString(key, defaultValue as? String) as T?
        Int::class -> getInt(key, defaultValue as? Int ?: -1) as T?
        Boolean::class -> getBoolean(key, defaultValue as? Boolean ?: false) as T?
        Float::class -> getFloat(key, defaultValue as? Float ?: -1f) as T?
        Long::class -> getLong(key, defaultValue as? Long ?: -1) as T?
        else -> throw UnsupportedOperationException("Not yet implemented")
    }
}