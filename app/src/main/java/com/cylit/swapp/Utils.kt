package com.cylit.swapp

import android.view.View
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*


fun separatorNumber(numero: String): String {
    var result: String
    numero.let {
        val formatter = DecimalFormat("#,###")
        val populationFormat = it.toLongOrNull()
        result = if (populationFormat != null) formatter.format(populationFormat) else it
    }
    return result
}

fun booleanToVisibility(bool: Boolean): Int {
    bool.let {
        return if (it) View.VISIBLE else View.GONE
    }

}

fun stringFormatDate(date: Date): String {
    date.let {
        val pattern = "dd-MM-yyyy"
        val sdfDate = SimpleDateFormat(pattern,
            Locale.getDefault())

        return sdfDate.format(it).toString()
    }

}