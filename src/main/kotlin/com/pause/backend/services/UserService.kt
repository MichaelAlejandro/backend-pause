package com.pause.backend.services

import com.pause.backend.exceptions.exceptions.ResourceNotFoundException
import com.pause.backend.mappers.toResponse
import com.pause.backend.models.requests.CreateUserRequest
import com.pause.backend.models.responses.UserResponse
import com.pause.backend.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {
    fun createUser(request: CreateUserRequest): UserResponse {
        val user = request.toEntity()
        return userRepository.save(user).toResponse()
    }

    fun getAllUsers(): List<UserResponse> =
        userRepository.findAll().map { it.toResponse() }

    fun getUserById(id: Long): UserResponse =
        userRepository.findById(id).orElseThrow {
            ResourceNotFoundException("User with ID $id not found")
        }.toResponse()

    fun updateUser(id: Long, request: CreateUserRequest): UserResponse {
        val user = userRepository.findById(id).orElseThrow {
            ResourceNotFoundException("User with ID $id not found")
        }
        user.userName = request.userName
        user.email = request.email
        return userRepository.save(user).toResponse()
    }

    fun deleteUser(id: Long) {
        val user = userRepository.findById(id).orElseThrow {
            ResourceNotFoundException("User with ID $id not found")
        }
        userRepository.delete(user)
    }
}
