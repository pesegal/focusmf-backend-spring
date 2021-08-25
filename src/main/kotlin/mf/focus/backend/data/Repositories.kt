package mf.focus.backend.data

import mf.focus.backend.data.entity.Project
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface ProjectRepository: CrudRepository<Project, UUID> {
}