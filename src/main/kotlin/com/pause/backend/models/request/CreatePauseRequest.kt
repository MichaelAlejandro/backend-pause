package com.pause.backend.models.requests

import java.time.LocalDateTime

data class CreatePauseRequest(
    val userId: Long,
    val durationMinutes: Int,
    val timestamp: LocalDateTime = LocalDateTime.now()
)
