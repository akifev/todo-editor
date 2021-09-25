package window

import TodoEditorApplicationState
import TodoEditorApplicationState.Companion.saveFileName
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.window.WindowState
import java.io.File

class TodoEditorWindowState(
    private val application: TodoEditorApplicationState,
    private val exit: (TodoEditorWindowState) -> Unit
) {
    fun exit() {
        save()
        exit(this)
    }

    private fun save() {
        val file = File(saveFileName)
        if (!file.exists()) {
            file.createNewFile()
        }
        file.writeText(text.text)
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