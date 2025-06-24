package com.pause.backend.models.responses

data class UserResponse(
    val id: Long,
    val uid: String,
    val userName: String,
    val email: String,
    val pauses: List<PauseResponse>,
    val reviews: List<ReviewResponse>,
    val pet: PetResponse?
)
