package com.pause.backend.models.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "users")
data class User(
    @Column(nullable = false, unique = true)
    val uid: String,

    @Column(nullable = false)
    var userName: String,

    @Column(nullable = false)
    var email: String,

    @OneToMany(mappedBy = "user")
    var pauses: List<Pause> = emptyList(),

    @OneToMany(mappedBy = "user")
    var reviews: List<Review> = emptyList(),

    @OneToOne(mappedBy = "user", orphanRemoval = true)
    var pet: Pet? = null
) : BaseEntity()