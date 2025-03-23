package uth.edu.taskuth.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uth.edu.taskuth.R
import uth.edu.taskuth.model.Task

@Composable
fun TaskItem(task: Task, onClick: () -> Unit) {
    val backgroundColor = when (task.priority) {
        "High" -> Color(0xFFFFCDD2)  // Đỏ nhạt
        "Medium" -> Color(0xFFFFF9C4) // Vàng nhạt
        "Low" -> Color(0xFFC8E6C9)   // Xanh lá nhạt
        else -> Color(0xFFBBDEFB)     // Xanh dương nhạt
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(backgroundColor)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = task.title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = task.description, color = Color.Gray, fontSize = 14.sp)
            }
//

                Image(painterResource(id = R.drawable.image_3),
                    contentDescription = "Back", contentScale = ContentScale.Fit,
                    modifier = Modifier.clickable { onClick() }.size(42.dp))


        }
        }
    }

