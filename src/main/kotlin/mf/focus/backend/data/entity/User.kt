package mf.focus.backend.data.entity

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "user", schema = "public")
class User (
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name="id")
    val id: UUID,

    @Column(name = "created_date")
    val createdDate: LocalDateTime,

    @Column(name = "updated_date")
    val updatedDate: LocalDateTime,

    @Column(name = "version")
    val version: Int,

    @Column(name = "email", nullable = false, length = 320)
    val email: String,

    @Column(name = "password", nullable = false)
    val password: String,

    @Column(name = "verified", nullable = false)
    val verified: Boolean,

    @Column(name = "first_name", length = 120)
    val firstName: String,

    @Column(name = "last_name", length = 120)
    val lastName: String
)