package uth.edu.taskuth.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import uth.edu.taskuth.ui.screen.TaskDetailScreen
import uth.edu.taskuth.ui.screen.TaskListScreen
import uth.edu.taskuth.viewModel.TaskViewModel

@Composable
fun MainScreen(viewModel: TaskViewModel = viewModel()) {
    val navController = rememberNavController()
    val taskList by viewModel.taskList
    val errorMessage by viewModel.errorMessage

    LaunchedEffect(Unit) {
        viewModel.fetchTasks()
    }

    NavHost(navController, startDestination = "list") {
        composable("list") {
            if (errorMessage.isNotEmpty()) {
                Text(text = errorMessage, color = Color.Red, modifier = Modifier.padding(16.dp))
            } else {
                TaskListScreen(navController = navController, taskList = taskList)
            }
        }
        composable("detail/{taskId}") { backStackEntry ->
            val taskId = backStackEntry.arguments?.getString("taskId")?.toIntOrNull()
            val selectedTask = taskList.find { it.id == taskId }

            if (selectedTask != null) {
                TaskDetailScreen(navController = navController, task = selectedTask)
            } else {
                Text("Task not found", modifier = Modifier.padding(16.dp))
            }
        }
    }
}
