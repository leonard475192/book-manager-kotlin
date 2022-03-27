package com.book.manager.presentation.form

import com.book.manager.domain.model.*
import java.time.LocalDate
import java.time.LocalDateTime

data class GetBookListResponse(val bookList: List<BookInfo>)

class BookInfo(
    val id: Long,
    val title: String,
    val author: String,
    val isRental: Boolean
) {
    constructor(model: BookWithRental) : this(
        model.book.id,
        model.book.title,
        model.book.author,
        model.isRental
    )
}

data class GetBookDetailResponse(
    val id: Long,
    val title: String,
    val author: String,
    val releaseDate: LocalDate,
    val rentalInfo: RentalInfo?,
    val rentalHistories: List<RentalHistoryInfo>,
) {
    constructor(model: BookWithRental, rentalHistories: List<RentalHistoryWithUserProfile>) : this(
        model.book.id,
        model.book.title,
        model.book.author,
        model.book.releaseData,
        model.rental?.let { RentalInfo(model.rental) },
        rentalHistories.map{ RentalHistoryInfo(it) }
    )
}

data class RentalInfo(
    val userId: Long,
    val rentalDateTime: LocalDateTime,
    val returnDeadline: LocalDateTime,
) {
    constructor(rental: Rental) : this(
        rental.userId,
        rental.rentalDatetime,
        rental.returnDeadline
    )
}

data class RentalHistoryInfo(
    val userId: Long,
    val name: String,
    val rentalDateTime: LocalDateTime,
    val returnDeadline: LocalDateTime,
) {
    constructor(rentalHistory: RentalHistoryWithUserProfile) : this(
        rentalHistory.userProfile.id,
        rentalHistory.userProfile.name,
        rentalHistory.rentalHistory.rentalDatetime,
        rentalHistory.rentalHistory.returnDatetime
    )
}

data class RegisterBookRequest(
    val id: Long,
    val title: String,
    val author: String,
    val releaseDate: LocalDate
)

data class UpdateBookRequest(
    val id: Long,
    val title: String?,
    val author: String?,
    val releaseDate: LocalDate?
)
