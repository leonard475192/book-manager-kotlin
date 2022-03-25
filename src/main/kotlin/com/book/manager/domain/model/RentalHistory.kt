package com.book.manager.domain.model

import java.time.LocalDateTime

data class RentalHistory (
    val id: Long,
    val rentalDatetime: LocalDateTime,
    val returnDatetime: LocalDateTime
)
