package com.pause.backend.services

import com.pause.backend.exceptions.exceptions.ResourceNotFoundException
import com.pause.backend.models.entities.User
import com.pause.backend.models.requests.CreateUserRequest
import com.pause.backend.repositories.UserRepository
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito.*
import java.util.*

class UserServiceTest {

    private lateinit var userRepository: UserRepository
    private lateinit var userService: UserService

    @BeforeEach
    fun setUp() {
        userRepository = mock(UserRepository::class.java)
        userService = UserService(userRepository)
    }

    @Test
    fun `should create a new user`() {
        val request = CreateUserRequest("uid123", "Michael", "maalejandro@puce.edu")
        val user = request.toEntity()

        `when`(userRepository.save(any(User::class.java))).thenReturn(user)

        val result = userService.createUser(request)

        assertEquals("Michael", result.userName)
        assertEquals("uid123", result.uid)
    }

    @Test
    fun `should return all users`() {
        val user = User(uid = "uid123", userName = "Michael", email = "maalejandro@puce.edu")

        `when`(userRepository.findAll()).thenReturn(listOf(user))

        val result = userService.getAllUsers()

        assertEquals(1, result.size)
        assertEquals("Michael", result[0].userName)
    }

    @Test
    fun `should return user by id`() {
        val user = User(uid = "uid123", userName = "Michael", email = "maalejandro@puce.edu")

        `when`(userRepository.findById(1L)).thenReturn(Optional.of(user))

        val result = userService.getUserById(1L)

        assertEquals("uid123", result.uid)
    }

    @Test
    fun `should throw exception when user not found`() {
        `when`(userRepository.findById(1L)).thenReturn(Optional.empty())

        assertThrows<ResourceNotFoundException> {
            userService.getUserById(1L)
        }
    }

    @Test
    fun `should update user`() {
        val existing = User(uid = "uid123", userName = "Primero", email = "primero@puce.edu.ec")
        val request = CreateUserRequest("uid123", "Segundo", "segundo@puce.edu.ec")

        `when`(userRepository.findById(1L)).thenReturn(Optional.of(existing))
        `when`(userRepository.save(existing)).thenReturn(existing)

        val result = userService.updateUser(1L, request)

        assertEquals("Segundo", result.userName)
        assertEquals("segundo@puce.edu.ec", result.email)
    }

    @Test
    fun `should throw exception when updating non-existent user`() {
        val request = CreateUserRequest("uid123", "Name", "email@puce.edu.ec")

        `when`(userRepository.findById(1L)).thenReturn(Optional.empty())

        assertThrows<ResourceNotFoundException> {
            userService.updateUser(1L, request)
        }
    }

    @Test
    fun `should delete user`() {
        val user = User(uid = "uid123", userName = "Michael", email = "maalejandro@puce.edu")

        `when`(userRepository.findById(1L)).thenReturn(Optional.of(user))

        userService.deleteUser(1L)

        verify(userRepository).delete(user)
    }

    @Test
    fun `should throw exception when deleting non-existent user`() {
        `when`(userRepository.findById(1L)).thenReturn(Optional.empty())

        assertThrows<ResourceNotFoundException> {
            userService.deleteUser(1L)
        }
    }
}
