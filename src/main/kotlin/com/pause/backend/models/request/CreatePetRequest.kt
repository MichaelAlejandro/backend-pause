package com.pause.backend.models.requests

data class CreatePetRequest(
    val userId: Long,
    val petName: String,
    val state: String = "neutral",
    val unlockedItems: Set<String> = emptySet(),
    val customization: String? = null
)
