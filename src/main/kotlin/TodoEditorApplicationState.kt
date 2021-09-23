import androidx.compose.runtime.*
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.window.TrayState
import window.TodoEditorWindowState

@Composable
fun rememberTodoEditorApplicationState() = remember {
    TodoEditorApplicationState().apply {
        newWindow()
    }
}

class TodoEditorApplicationState {
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
        _windows.add(
            TodoEditorWindowState(
                application = this,
                exit = _windows::remove
            )
        )
    }

    fun exit() {
        for (window in _windows.reversed()) {
            window.exit()
        }
    }
}