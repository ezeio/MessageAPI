package com.message.app.messageapi.model


import com.fasterxml.jackson.annotation.JsonIgnore

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import java.time.LocalDateTime

@Entity
class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null
    var message: String? = null
    var title: String? = null
    @get:JsonIgnore
    var creationTime: LocalDateTime? = null
        set(creationTime) {
            field = creationTime
            modifiedTime = creationTime
        }
    @get:JsonIgnore
    var modifiedTime: LocalDateTime? = null

    constructor(title: String, message: String) {

    }

    constructor() {}
}
