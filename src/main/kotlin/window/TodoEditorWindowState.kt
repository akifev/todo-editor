package window

import TodoEditorApplicationState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.window.WindowState

class TodoEditorWindowState(
    private val application: TodoEditorApplicationState,
    private val exit: (TodoEditorWindowState) -> Unit
) {
    fun exit() {
        save()
        exit(this)
    }

    private fun save() {
        // save text
    }

    val window = WindowState()

    var isChanged by mutableStateOf(false)
        private set

    var text: TextFieldValue
        get() = application.text
        set(value) {
            application.text = value
            isChanged = true
        }
}