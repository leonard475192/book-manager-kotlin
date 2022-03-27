package com.book.manager.infrastructure.database.record.custom

import java.time.LocalDate
import java.time.LocalDateTime

class RentalHistoryWithBookRecord(
    var id: Long? = null,
    var bookId: Long? = null,
    var title: String? = null,
    var author: String? = null,
    var releaseDate: LocalDate? = null,
    var rentalDatetime: LocalDateTime? = null,
    var returnDatetime: LocalDateTime? = null
)
