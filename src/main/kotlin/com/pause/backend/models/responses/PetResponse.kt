package com.pause.backend.models.responses

data class PetResponse(
    val id: Long,
    val petName: String,
    val state: String,
    val unlockedItems: Set<String>,
    val customization: String?,
    val userId: Long
)
