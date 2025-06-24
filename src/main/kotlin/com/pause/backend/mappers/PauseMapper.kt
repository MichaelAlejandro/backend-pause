package com.pause.backend.mappers

import com.pause.backend.models.entities.Pause
import com.pause.backend.models.responses.PauseResponse

fun Pause.toResponse(): PauseResponse =
    PauseResponse(
        id = this.id,
        durationMinutes = this.durationMinutes,
        timestamp = this.timestamp,
        userId = this.user.id
    )
