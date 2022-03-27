package com.book.manager.infrastructure.database.record.custom

import java.time.LocalDate
import java.time.LocalDateTime

class RentalHistoryWithUserRecord(
    var id: Long? = null,
    var userId: Long? = null,
    var name: String? = null,
    var rentalDatetime: LocalDateTime? = null,
    var returnDatetime: LocalDateTime? = null
)
