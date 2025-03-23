package uth.edu.taskuth.api

import retrofit2.http.GET
import retrofit2.Response
import retrofit2.http.Path
import uth.edu.taskuth.model.Task
import uth.edu.taskuth.model.TaskResponse


interface TaskApiService {
    @GET("tasks")
    suspend fun getTasks(): Response<TaskResponse>
    @GET("tasks/{id}")
    suspend fun getTaskDetail(@Path("id") taskId: Int): Response<Task>
    companion object {
        val instance: TaskApiService by lazy {
            RetrofitClient.instance.create(TaskApiService::class.java)
        }
    }

}
