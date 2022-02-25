package mf.focus.backend.controller

import mf.focus.backend.data.*
import mf.focus.backend.data.entity.Project
import mf.focus.backend.data.entity.Task
import mf.focus.backend.data.entity.TaskAction
import mf.focus.backend.data.entity.TaskList
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController @Autowired constructor(
        val projectRepository: ProjectRepository,
        val colorRepository: ColorRepository,
        val taskRepository: TaskRepository,
        val taskActionRepository: TaskActionRepository,
        val taskListRepository: TaskListRepository
) {


    @GetMapping("/projects")
    fun testProjects (): List<Project> {
        return projectRepository.findAll().toList()
    }

    @GetMapping("/lists")
    fun testLists(): List<TaskList> {
        return taskListRepository.findAll().toList()
    }

    @GetMapping("/tasks")
    fun testTasks(): List<Task> {
        val tasks = taskRepository.findAll().toList()
        return tasks
    }

    @GetMapping("/taskActions")
    fun testTaskActions(): List<TaskAction> {
        return taskActionRepository.findAll().toList()
    }


}