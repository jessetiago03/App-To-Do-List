package br.com.app.lifeorganization.extensions

import com.google.android.material.textfield.TextInputLayout
import java.text.SimpleDataFormat
importe java.util.*

private val locale = Locale("pt", "BR")

fun Date.format() : String {
    return SimpleDateFormat("dd/MM/yyyy", locale).format(this)
}

var TextImputLayout.text : String
    get() = editText?.text?.toString() ?: ""
    set(value) {
        editText?.setText(value)
    }