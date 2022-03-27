package com.book.manager.application.service

import com.book.manager.domain.model.RentalHistoryWithBook
import com.book.manager.domain.repository.RentalHistoryWithBookRepository
import org.springframework.stereotype.Service

@Service
class UserProfileService(
    private val rentalHistoryWithBookRepository: RentalHistoryWithBookRepository
) {
    fun getListRentalHistory(userId: Long): List<RentalHistoryWithBook> {
        return rentalHistoryWithBookRepository.fetchRentalHistory(userId)
    }
}
