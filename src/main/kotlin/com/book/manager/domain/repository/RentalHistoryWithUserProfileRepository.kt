package com.book.manager.domain.repository

import com.book.manager.domain.model.RentalHistoryWithUserProfile

interface RentalHistoryWithUserProfileRepository {
    fun fetchRentalHistory(bookId: Long): List<RentalHistoryWithUserProfile>
}
