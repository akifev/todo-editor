package editor

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle


fun String.asAnnotated(): AnnotatedString = buildAnnotatedString {
    val text = this@asAnnotated
    withStyle(Theme.text.simple) {
        append(text)
        addStyle(Theme.text.bold, text, Regex("#.*"))
        addStyle(Theme.text.strikethrough, text, Regex("\\w.*@done\\b"))
        addStyle(Theme.text.tag, text, Regex("[\\r\\t ]*@\\w+"))
        addStyle(Theme.text.date, text, Regex("[\\r\\t ]*(\\d{2}/\\d{2}(/\\d{4})?)"))
        addStyle(Theme.text.time, text, Regex("[\\r\\t ]*(\\d{2}:\\d{2})"))
    }
}

private fun AnnotatedString.Builder.addStyle(style: SpanStyle, text: String, regexp: Regex) {
    for (result in regexp.findAll(text)) {
        addStyle(style, result.range.first, result.range.last + 1)
    }
}