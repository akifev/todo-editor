package editor

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration

object Theme {
    val colors: Colors = Colors()

    val text: Text = Text()

    class Colors(
        val backgroundLight: Color = Color.LightGray,

        val black: Color = Color.Black,
        val gray: Color = Color.Gray,
        val blue: Color = Color.Blue,
        val magenta: Color = Color.Magenta
    )

    class Text(
        val simple: SpanStyle = SpanStyle(
            color = colors.black,
            fontWeight = FontWeight.Normal,
        ),
        val bold: SpanStyle = SpanStyle(
            fontWeight = FontWeight.Bold,
        ),
        val strikethrough: SpanStyle = SpanStyle(
            textDecoration = TextDecoration.LineThrough
        ),
        val tag: SpanStyle = SpanStyle(
            color = colors.gray,
            fontWeight = FontWeight.SemiBold,
            textDecoration = TextDecoration.None
        ),
        val date: SpanStyle = SpanStyle(
            color = colors.magenta,
            fontWeight = FontWeight.SemiBold,
            textDecoration = TextDecoration.None
        ),
        val time: SpanStyle = SpanStyle(
            color = colors.blue,
            fontWeight = FontWeight.SemiBold,
            textDecoration = TextDecoration.None
        )
    )
}