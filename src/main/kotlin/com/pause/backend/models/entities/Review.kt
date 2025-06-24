package com.pause.backend.models.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "reviews")
data class Review(
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

    @Column(nullable = false)
    val question: String,

    @Column(nullable = false)
    val userAnswer: String,

    @Column(nullable = false)
    val correct: Boolean,

    @Column(nullable = false)
    val timestamp: LocalDateTime = LocalDateTime.now()
) : BaseEntity()