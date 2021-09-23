package window

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.window.Window
import editor.asAnnotated

@Composable
fun TodoEditorWindow(state: TodoEditorWindowState) {
    Window(
        onCloseRequest = state::exit,
        state = state.window,
        title = "todo editor"
    ) {
        BasicTextField(
            value = state.text,
            onValueChange = {
                state.text = TextFieldValue(it.text.asAnnotated(), it.selection)
            },
            modifier = Modifier.fillMaxSize()
        )
    }
}