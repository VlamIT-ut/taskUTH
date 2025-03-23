package uth.edu.taskuth.model

data class TaskResponse(
    val isSuccess: Boolean,
    val message: String,
    val data: List<Task>
)
