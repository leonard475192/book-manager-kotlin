package com.book.manager.infrastructure.database.repository

import com.book.manager.domain.model.RentalHistory
import com.book.manager.domain.repository.RentalHistoryRepository
import com.book.manager.infrastructure.database.mapper.RentalHistoryMapper
import com.book.manager.infrastructure.database.mapper.insert
import com.book.manager.infrastructure.database.record.RentalHistoryRecord
import org.springframework.stereotype.Repository

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@Repository
class RentalHistoryRepositoryImpl(
    private val rentalHistoryMapper: RentalHistoryMapper
) : RentalHistoryRepository {
    override fun register(rentalHistory: RentalHistory, bookId: Long, userId: Long) {
        rentalHistoryMapper.insert(toRecord(rentalHistory, bookId, userId))
    }

    private fun toRecord(
        model: RentalHistory,
        bookId: Long,
        userId: Long
    ): RentalHistoryRecord {
        return RentalHistoryRecord(
            bookId = bookId,
            userId = userId,
            rentalDatetime = model.rentalDatetime,
            returnDatetime = model.returnDatetime
        )
    }
}
