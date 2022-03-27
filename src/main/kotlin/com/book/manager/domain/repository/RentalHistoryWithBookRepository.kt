package com.book.manager.domain.repository

import com.book.manager.domain.model.RentalHistoryWithBook

interface RentalHistoryWithBookRepository {
    fun fetchRentalHistory(userId: Long): List<RentalHistoryWithBook>
}
