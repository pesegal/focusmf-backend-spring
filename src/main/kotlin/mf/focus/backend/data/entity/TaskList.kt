package mf.focus.backend.data.entity

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "list")
class TaskList(
    @Id @GeneratedValue(generator = "UUID") val id: UUID,

    @Column(name = "created_date") val createdDate: LocalDateTime,
    @Column(name = "updated_date") val updatedDate: LocalDateTime,
    @Column(name = "deleted_timestamp") val deletedTime: LocalDateTime,
    @Column val version: Int,
    @Column val name: String,
    @Column val position: Int,

    @ManyToOne
    @JoinColumn(name = "`userId`")
    val user: User

)