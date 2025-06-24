package com.pause.backend.models.responses

import java.time.LocalDateTime

data class PauseResponse(
    val id: Long,
    val durationMinutes: Int,
    val timestamp: LocalDateTime,
    val userId: Long
)
