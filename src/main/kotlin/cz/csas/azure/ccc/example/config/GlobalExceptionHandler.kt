package cz.csas.azure.ccc.example.config

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.CannotCreateTransactionException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler


@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler
    fun handleIllegalArgumentException(ex: IllegalArgumentException): ResponseEntity<Any> {
        val response = mapOf(
            "message" to ex.message
        )
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response)
    }

    @ExceptionHandler
    fun handleDbException(ex: CannotCreateTransactionException): ResponseEntity<Any> {
        val response = mapOf(
            "message" to "Database unavailable."
        )
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response)
    }
}
