import androidx.compose.runtime.*
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.window.TrayState
import editor.asAnnotated
import window.TodoEditorWindowState
import java.io.File

@Composable
fun rememberTodoEditorApplicationState() = remember {
    TodoEditorApplicationState().apply {
        newWindow()
    }
}

class TodoEditorApplicationState {
    companion object {
        const val saveFileName = "save.txt"
    }

    val tray = TrayState()

    private val _windows = mutableStateListOf<TodoEditorWindowState>()
    val windows: List<TodoEditorWindowState> get() = _windows

    private var _text by mutableStateOf(TextFieldValue())

    var text: TextFieldValue
        get() = _text
        set(value) {
            _text = value
        }

    fun newWindow() {
        text = TextFieldValue(readSave().asAnnotated())
        _windows.add(
            TodoEditorWindowState(
                application = this,
                exit = _windows::remove
            )
        )
    }

    private fun readSave(): String {
        val file = File(saveFileName)
        if (!file.exists()) {
            file.createNewFile()
        }
        return file.readText()
    }

    fun exit() {
        for (window in _windows.reversed()) {
            window.exit()
        }
    }
}