package com.netmera.netmerafintech.utils

import android.annotation.SuppressLint
import android.content.Context

@SuppressLint("StaticFieldLeak")
object UserDefaultsHelper {
    private lateinit var context: Context
    private const val EMAIL_KEY = "email"
    private const val NAME_KEY = "name"
    private const val LAST_NAME_KEY = "lastname"
    private const val BIRTH_DATE_KEY = "birthdate"
    private const val PHONE_KEY = "phone"
    private const val CITY_KEY = "city"
    private const val COMPANY_NAME_KEY = "company_name"
    private const val COMPANY_EMAIL_KEY = "company_email"
    private const val TITLE_KEY = "title"

    fun init(context: Context) {
        this.context = context
    }

    private val sharedPreferences by lazy {
        context.getSharedPreferences("user_data", Context.MODE_PRIVATE)
    }

    var email: String?
        get() = sharedPreferences.getString(EMAIL_KEY, null)
        set(value) {
            sharedPreferences.edit().putString(EMAIL_KEY, value).apply()
        }

    var name: String?
        get() = sharedPreferences.getString(NAME_KEY, null)
        set(value) {
            sharedPreferences.edit().putString(NAME_KEY, value).apply()
        }

    var lastName: String?
        get() = sharedPreferences.getString(LAST_NAME_KEY, null)
        set(value) {
            sharedPreferences.edit().putString(LAST_NAME_KEY, value).apply()
        }

    var birthDate: String?
        get() = sharedPreferences.getString(BIRTH_DATE_KEY, null)
        set(value) {
            sharedPreferences.edit().putString(BIRTH_DATE_KEY, value).apply()
        }

    var phone: String?
        get() = sharedPreferences.getString(PHONE_KEY, null)
        set(value) {
            sharedPreferences.edit().putString(PHONE_KEY, value).apply()
        }

    var city: String?
        get() = sharedPreferences.getString(CITY_KEY, null)
        set(value) {
            sharedPreferences.edit().putString(CITY_KEY, value).apply()
        }

    var companyName: String?
        get() = sharedPreferences.getString(COMPANY_NAME_KEY, null)
        set(value) {
            sharedPreferences.edit().putString(COMPANY_NAME_KEY, value).apply()
        }

    var companyEmail: String?
        get() = sharedPreferences.getString(COMPANY_EMAIL_KEY, null)
        set(value) {
            sharedPreferences.edit().putString(COMPANY_EMAIL_KEY, value).apply()
        }

    var title: String?
        get() = sharedPreferences.getString(TITLE_KEY, null)
        set(value) {
            sharedPreferences.edit().putString(TITLE_KEY, value).apply()
        }

    fun clear() {
        sharedPreferences.edit().clear().apply()
    }
}
