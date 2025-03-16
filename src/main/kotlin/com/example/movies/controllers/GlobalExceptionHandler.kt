package com.example.movies.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(IllegalStateException::class)
    fun handleException(ex: IllegalStateException): ResponseEntity<String> = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.message)

    @ExceptionHandler(Exception::class)
    fun handleException(ex: Exception): ResponseEntity<String> = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.message)
}
