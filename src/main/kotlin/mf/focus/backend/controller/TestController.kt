package mf.focus.backend.controller

import mf.focus.backend.data.ProjectRepository
import mf.focus.backend.data.entity.Project
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController @Autowired constructor(
        val projectRepository: ProjectRepository
) {


    @GetMapping("/")
    fun test (): List<Project> {
        return projectRepository.findAll().toList()
    }
}