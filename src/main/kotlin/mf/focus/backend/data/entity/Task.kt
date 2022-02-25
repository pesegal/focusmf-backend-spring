package mf.focus.backend.data.entity

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
class Task(
    @Id @GeneratedValue(generator = "UUID") val id: UUID,
    @Column(name = "created_date") val createdDate: LocalDateTime,
    @Column(name = "updated_date") val updatedDate: LocalDateTime,
    @Column(name = "deleted_timestamp") val deletedTime: LocalDateTime,
    @Column val version: Int,
    @Column(name = "`columnPos`") val columnPos: Int,
    @Column val name: String,
    @Column val notes: String,

    @ManyToOne
    @JoinColumn(name = "`userId`")
    val user: User,

    @ManyToOne
    @JoinColumn(name = "`listId`")
    val list: TaskList,

    @ManyToMany
    @JoinTable(
        name = "`project_tasks_task`",
        joinColumns = [JoinColumn(name = "`taskId`")],
        inverseJoinColumns = [JoinColumn(name = "`projectId`")]
    )
    val projects: List<Project>
)