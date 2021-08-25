package mf.focus.backend.data.entity

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "project")
class Project(
        @Id
        @GeneratedValue(generator = "UUID")
        val id: UUID,

        @Column(name = "created_date")
        val createdDate: LocalDateTime,

        @Column(name = "updated_date")
        val updatedDate: LocalDateTime,

        @Column(name = "deleted_timestamp")
        val deletedDate: LocalDateTime,

        @Column
        val version: Int,

        @Column
        val name: String,

        @Column(name="`userId`")
        val userId: UUID,

        @Column(name="`colorId`")
        val colorId: UUID

)