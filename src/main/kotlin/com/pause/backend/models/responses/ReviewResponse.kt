package com.pause.backend.models.responses

import java.time.LocalDateTime

data class ReviewResponse(
    val id: Long,
    val question: String,
    val userAnswer: String,
    val correct: Boolean,
    val timestamp: LocalDateTime,
    val userId: Long
)
