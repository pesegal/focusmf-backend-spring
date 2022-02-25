package mf.focus.backend.data.entity

import java.util.*
import javax.persistence.*

@Entity
class Permission (
    @Id
    @GeneratedValue(generator = "UUID") val id: UUID,
    @Column val permission: String,
    @ManyToOne
    @JoinColumn(name = "`userId`")
    val user: User,
)

