@file:OptIn(ExperimentalMaterial3Api::class)

package uth.edu.taskuth.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import uth.edu.taskuth.R
import uth.edu.taskuth.model.Task

@Composable
fun TaskListScreen(navController: NavController, taskList: List<Task>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {  Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("List", fontWeight = FontWeight.Bold)
                } },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Image(painterResource(id = R.drawable.image_2),
                            contentDescription = "Back",
                            modifier = Modifier.size(40.dp))
                    }
                }
            )
        }
    ) { paddingValues ->
        if (taskList.isEmpty()) {
            EmptyTaskScreen()
        } else {
            LazyColumn(modifier = Modifier.padding(paddingValues)) {
                items(taskList) { task ->
                    TaskItem(task = task, onClick = {
                        navController.navigate("detail/${task.id}") // Chuyển sang màn hình chi tiết
                    })
                }
            }
        }
    }
}
