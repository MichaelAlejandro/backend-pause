package com.pause.backend.mappers

import com.pause.backend.models.entities.Review
import com.pause.backend.models.responses.ReviewResponse

fun Review.toResponse(): ReviewResponse =
    ReviewResponse(
        id = this.id,
        question = this.question,
        userAnswer = this.userAnswer,
        correct = this.correct,
        timestamp = this.timestamp,
        userId = this.user.id
    )
