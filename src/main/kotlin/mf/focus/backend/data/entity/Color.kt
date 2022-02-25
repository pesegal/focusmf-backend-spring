package mf.focus.backend.data.entity

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Color (
    @Id
    @GeneratedValue(generator = "UUID")
    val id: UUID,

    @Column
    val hex: String,

    @Column
    val name: String
)