package mf.focus.backend.fetchers

import graphql.schema.DataFetcher
import mf.focus.backend.data.ProjectRepository
import mf.focus.backend.data.entity.Project
import org.springframework.stereotype.Component


@Component
class ProjectDataFetchers(val projectRepository: ProjectRepository) {
    fun getProjects(): DataFetcher<List<Project>> {
        return DataFetcher {
            return@DataFetcher projectRepository.findAll().toList()
        }
    }
}