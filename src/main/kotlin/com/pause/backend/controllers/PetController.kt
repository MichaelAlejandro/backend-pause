package com.pause.backend.controllers

import com.pause.backend.models.requests.CreatePetRequest
import com.pause.backend.models.responses.PetResponse
import com.pause.backend.routes.Routes
import com.pause.backend.services.PetService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(Routes.PETS)
class PetController(
    private val petService: PetService
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createPet(@RequestBody request: CreatePetRequest): PetResponse =
        petService.createPet(request)

    @GetMapping
    fun getAllPets(): List<PetResponse> = petService.getAllPets()

    @GetMapping(Routes.ID)
    fun getPetById(@PathVariable id: Long): PetResponse = petService.getPetById(id)

    @PutMapping(Routes.ID)
    fun updatePet(@PathVariable id: Long, @RequestBody request: CreatePetRequest): PetResponse =
        petService.updatePet(id, request)

    @DeleteMapping(Routes.ID)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletePet(@PathVariable id: Long) = petService.deletePet(id)
}
