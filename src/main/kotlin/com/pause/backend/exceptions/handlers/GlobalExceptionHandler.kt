package com.pause.backend.exceptions.handlers

import com.pause.backend.exceptions.exceptions.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleNotFound(ex: ResourceNotFoundException): ResponseEntity<Map<String, String>> =
        ResponseEntity(mapOf("error" to ex.message.orEmpty()), HttpStatus.NOT_FOUND)

    @ExceptionHandler(DuplicateResourceException::class)
    fun handleDuplicate(ex: DuplicateResourceException): ResponseEntity<Map<String, String>> =
        ResponseEntity(mapOf("error" to ex.message.orEmpty()), HttpStatus.CONFLICT)

    @ExceptionHandler(InvalidRequestException::class)
    fun handleInvalid(ex: InvalidRequestException): ResponseEntity<Map<String, String>> =
        ResponseEntity(mapOf("error" to ex.message.orEmpty()), HttpStatus.BAD_REQUEST)

    @ExceptionHandler(BadRequestException::class)
    fun handleBadRequest(ex: BadRequestException): ResponseEntity<Map<String, String>> =
        ResponseEntity(mapOf("error" to ex.message.orEmpty()), HttpStatus.BAD_REQUEST)

    @ExceptionHandler(HandleUnauthorizedException::class)
    fun handleUnauthorized(ex: HandleUnauthorizedException): ResponseEntity<Map<String, String>> =
        ResponseEntity(mapOf("error" to ex.message.orEmpty()), HttpStatus.UNAUTHORIZED)

    @ExceptionHandler(Exception::class)
    fun handleGeneric(ex: Exception): ResponseEntity<Map<String, String>> =
        ResponseEntity(mapOf("error" to "Unexpected error: ${ex.message}"), HttpStatus.INTERNAL_SERVER_ERROR)
}
