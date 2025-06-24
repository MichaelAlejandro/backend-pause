package com.pause.backend.services

import com.pause.backend.exceptions.exceptions.ResourceNotFoundException
import com.pause.backend.mappers.toResponse
import com.pause.backend.models.entities.Pause
import com.pause.backend.models.requests.CreatePauseRequest
import com.pause.backend.models.responses.PauseResponse
import com.pause.backend.repositories.PauseRepository
import com.pause.backend.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class PauseService(
    private val pauseRepository: PauseRepository,
    private val userRepository: UserRepository
) {
    fun createPause(request: CreatePauseRequest): PauseResponse {
        val user = userRepository.findById(request.userId).orElseThrow {
            ResourceNotFoundException("User not found")
        }
        val pause = Pause(
            user = user,
            durationMinutes = request.durationMinutes,
            timestamp = request.timestamp
        )
        return pauseRepository.save(pause).toResponse()
    }

    fun getAll(): List<PauseResponse> = pauseRepository.findAll().map { it.toResponse() }

    fun getById(id: Long): PauseResponse =
        pauseRepository.findById(id).orElseThrow {
            ResourceNotFoundException("Pause with ID $id not found")
        }.toResponse()

    fun delete(id: Long) {
        val pause = pauseRepository.findById(id).orElseThrow {
            ResourceNotFoundException("Pause with ID $id not found")
        }
        pauseRepository.delete(pause)
    }
}
