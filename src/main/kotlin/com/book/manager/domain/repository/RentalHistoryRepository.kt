package com.book.manager.domain.repository

import com.book.manager.domain.model.RentalHistory

interface RentalHistoryRepository {
    fun register(rentalHistory: RentalHistory, bookId: Long, userId: Long)
}
