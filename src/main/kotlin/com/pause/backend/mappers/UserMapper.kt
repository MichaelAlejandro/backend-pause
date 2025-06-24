package com.pause.backend.mappers

import com.pause.backend.models.entities.User
import com.pause.backend.models.responses.UserResponse

fun User.toResponse(): UserResponse =
    UserResponse(
        id = this.id,
        uid = this.uid,
        userName = this.userName,
        email = this.email,
        pauses = this.pauses.map { it.toResponse() },
        reviews = this.reviews.map { it.toResponse() },
        pet = this.pet?.toResponse()
    )
