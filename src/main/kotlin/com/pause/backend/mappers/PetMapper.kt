package com.pause.backend.mappers

import com.pause.backend.models.entities.Pet
import com.pause.backend.models.responses.PetResponse

fun Pet.toResponse(): PetResponse =
    PetResponse(
        id = this.id,
        petName = this.petName,
        state = this.state,
        unlockedItems = this.unlockedItems,
        customization = this.customization,
        userId = this.user.id
    )
