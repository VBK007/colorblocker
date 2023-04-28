package com.withcodeplays.utils

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import androidx.annotation.StringDef
import com.withcodeplays.familytracker.di.PreferenceManager
import timber.log.Timber
import java.util.*

object LocaleManager {
    const val ENGLISH = "en"
    const val HINDI = "hi"
    const val SPANISH = "es"

    /**
     * SharedPreferences Key
     */
    private const val LANGUAGE_KEY = "language_key"

    /**
     * set current pref locale
     */
    fun setLocale(mContext: Context): Context {
        return updateResources(mContext, getLanguagePref(mContext))
    }

    /**
     * Set new Locale with context
     */
    fun setNewLocale(mContext: Context, @LocaleDef language: String): Context {
        setLanguagePref(mContext, language)
        return updateResources(mContext, language)
    }

    /**
     * Get saved Locale from SharedPreferences
     *
     * @param mContext current context
     * @return current locale key by default return english locale
     */
    fun getLanguagePref(mContext: Context?): String? {
        val mPreferences = PreferenceManager(mContext!!)
        return mPreferences.selectedLanguage
    }

    /**
     * set pref key
     */
    private fun setLanguagePref(mContext: Context, localeKey: String) {
        val mPreferences = PreferenceManager(mContext)
        mPreferences.selectedLanguage = localeKey
    }

    /**
     * update resource
     */
    private fun updateResources(ctx: Context, language: String?): Context {
        var context = ctx
        val locale = Locale(language!!)
        Locale.setDefault(locale)
        val res = context.resources
        val config = Configuration(res.configuration)
        Timber.d("Logger value is $language")
        config.setLocale(locale)
        context = context.createConfigurationContext(config)
        return context
    }

    /**
     * get current locale
     */
    fun getLocale(res: Resources): Locale {
        val config = res.configuration
        return if (Build.VERSION.SDK_INT >= 24) config.locales[0] else config.locale
    }

    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    @StringDef(ENGLISH, HINDI, SPANISH)
    annotation class LocaleDef {
        companion object {
            var SUPPORTED_LOCALES = arrayOf(ENGLISH, HINDI, SPANISH)
        }
    }
}