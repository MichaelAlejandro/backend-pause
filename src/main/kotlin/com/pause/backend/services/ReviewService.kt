package com.pause.backend.services

import com.pause.backend.exceptions.exceptions.ResourceNotFoundException
import com.pause.backend.mappers.toResponse
import com.pause.backend.models.entities.Review
import com.pause.backend.models.requests.CreateReviewRequest
import com.pause.backend.models.responses.ReviewResponse
import com.pause.backend.repositories.ReviewRepository
import com.pause.backend.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class ReviewService(
    private val reviewRepository: ReviewRepository,
    private val userRepository: UserRepository
) {
    fun createReview(request: CreateReviewRequest): ReviewResponse {
        val user = userRepository.findById(request.userId).orElseThrow {
            ResourceNotFoundException("User not found")
        }
        val review = Review(
            user = user,
            question = request.question,
            userAnswer = request.userAnswer,
            correct = request.correct,
            timestamp = request.timestamp
        )
        return reviewRepository.save(review).toResponse()
    }

    fun getAll(): List<ReviewResponse> = reviewRepository.findAll().map { it.toResponse() }

    fun getById(id: Long): ReviewResponse =
        reviewRepository.findById(id).orElseThrow {
            ResourceNotFoundException("Review with ID $id not found")
        }.toResponse()

    fun delete(id: Long) {
        val review = reviewRepository.findById(id).orElseThrow {
            ResourceNotFoundException("Review with ID $id not found")
        }
        reviewRepository.delete(review)
    }
}
