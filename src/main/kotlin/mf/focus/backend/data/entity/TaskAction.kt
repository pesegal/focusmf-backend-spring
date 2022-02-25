package mf.focus.backend.data.entity

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "`task_action`")
class TaskAction(
    @Id @GeneratedValue(generator = "UUID") val id: UUID,
    @Column val start: LocalDateTime,
    @Column val end: LocalDateTime,
    @Column(name = "`actionType`") val actionType: String,

    @ManyToOne
    @JoinColumn(name = "`taskId`")
    val task: Task
)