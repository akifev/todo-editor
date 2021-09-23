import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.window.MenuScope
import androidx.compose.ui.window.Tray
import window.TodoEditorWindow

@Composable
fun TodoEditorApplication(state: TodoEditorApplicationState) {
    if (state.windows.isNotEmpty()) {
        ApplicationTray(state)
    }

    for (window in state.windows) {
        key(window) {
            TodoEditorWindow(window)
        }
    }
}

@Composable
private fun ApplicationTray(state: TodoEditorApplicationState) {
    Tray(
        icon = ColorPainter(Color.Red),
        state = state.tray,
        hint = "todo editor",
        menu = { ApplicationMenu(state) }
    )
}

@Composable
private fun MenuScope.ApplicationMenu(state: TodoEditorApplicationState) {
    fun exit() = state.exit()

    Item("New window", onClick = state::newWindow)
    Separator()
    Item("Exit", onClick = { exit() })
}