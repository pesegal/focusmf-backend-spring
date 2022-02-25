package mf.focus.backend.data

import mf.focus.backend.data.entity.*
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface ProjectRepository: CrudRepository<Project, UUID> {}

@Repository
interface ColorRepository: CrudRepository<Color, UUID> {}

@Repository
interface ListRepository: CrudRepository<TaskList, UUID> {}

@Repository
interface TaskRepository: CrudRepository<Task, UUID> {}

@Repository
interface TaskActionRepository: CrudRepository<TaskAction, UUID> {}

@Repository
interface TaskListRepository: CrudRepository<TaskList, UUID> {}

@Repository
interface UserRepository: CrudRepository<User, UUID> {}