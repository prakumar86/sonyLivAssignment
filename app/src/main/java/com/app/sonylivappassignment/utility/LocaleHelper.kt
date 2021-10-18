package com.app.sonylivappassignment.utility

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import java.util.*

class LocaleHelper {
    companion object {
        fun setLocale(context: Context, language: String?): Context {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                updateResources(context, language)
            } else updateResourcesLegacy(context, language)
        }

        @TargetApi(Build.VERSION_CODES.N)
        private fun updateResources(context: Context, language: String?): Context {
            val locale = Locale(language)
            Locale.setDefault(locale)
            val configuration = context.resources.configuration
            configuration.setLocale(locale)
            configuration.setLayoutDirection(locale)
            return context.createConfigurationContext(configuration)
        }

        private fun updateResourcesLegacy(context: Context, language: String?): Context {
            val locale = Locale(language)
            Locale.setDefault(locale)
            val resources = context.resources
            val configuration = resources.configuration
            configuration.locale = locale
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                configuration.setLayoutDirection(locale)
            }
            resources.updateConfiguration(configuration, resources.displayMetrics)
            return context
        }

        fun getUsLocaleName(lng: String?): String {
            var loc = Locale(lng)
            var name: String = loc.getDisplayLanguage(Locale.US) // English
            return name

        }
    }
}