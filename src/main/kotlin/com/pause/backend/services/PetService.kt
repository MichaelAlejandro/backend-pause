package com.pause.backend.services

import com.pause.backend.exceptions.exceptions.ResourceNotFoundException
import com.pause.backend.mappers.toResponse
import com.pause.backend.models.entities.Pet
import com.pause.backend.models.requests.CreatePetRequest
import com.pause.backend.models.responses.PetResponse
import com.pause.backend.repositories.PetRepository
import com.pause.backend.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class PetService(
    private val petRepository: PetRepository,
    private val userRepository: UserRepository
) {
    fun createPet(request: CreatePetRequest): PetResponse {
        val user = userRepository.findById(request.userId).orElseThrow {
            ResourceNotFoundException("User not found")
        }
        val pet = Pet(
            user = user,
            petName = request.petName,
            state = request.state,
            unlockedItems = request.unlockedItems,
            customization = request.customization
        )
        return petRepository.save(pet).toResponse()
    }

    fun getPetById(id: Long): PetResponse =
        petRepository.findById(id).orElseThrow {
            ResourceNotFoundException("Pet with ID $id not found")
        }.toResponse()

    fun getAllPets(): List<PetResponse> =
        petRepository.findAll().map { it.toResponse() }

    fun updatePet(id: Long, request: CreatePetRequest): PetResponse {
        val pet = petRepository.findById(id).orElseThrow {
            ResourceNotFoundException("Pet with ID $id not found")
        }
        pet.petName = request.petName
        pet.state = request.state
        pet.customization = request.customization
        pet.unlockedItems = request.unlockedItems
        return petRepository.save(pet).toResponse()
    }

    fun deletePet(id: Long) {
        val pet = petRepository.findById(id).orElseThrow {
            ResourceNotFoundException("Pet with ID $id not found")
        }
        petRepository.delete(pet)
    }
}
