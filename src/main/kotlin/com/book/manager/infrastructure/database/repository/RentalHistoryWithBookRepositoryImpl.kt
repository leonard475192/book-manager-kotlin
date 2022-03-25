package com.book.manager.infrastructure.database.repository

import com.book.manager.domain.model.*
import com.book.manager.domain.repository.RentalHistoryWithBookRepository
import com.book.manager.infrastructure.database.mapper.custom.RentalHistoryWithBookMapper
import com.book.manager.infrastructure.database.mapper.custom.selectByUserId
import com.book.manager.infrastructure.database.record.custom.RentalHistoryWithBookRecord
import org.springframework.stereotype.Repository

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@Repository
class RentalHistoryWithBookRepositoryImpl(
    private val rentalHistoryWithBookMapper: RentalHistoryWithBookMapper
) : RentalHistoryWithBookRepository {
    override fun fetchRentalHistory(userId: Long): List<RentalHistoryWithBook> {
        return rentalHistoryWithBookMapper.selectByUserId(userId).map { toModel(it) }
    }

    private fun toModel(record: RentalHistoryWithBookRecord): RentalHistoryWithBook {
        val rentalHistory = RentalHistory(
            record.id!!,
            record.rentalDatetime!!,
            record.returnDatetime!!
        )
        val book = Book(
            record.bookId!!,
            record.title!!,
            record.author!!,
            record.releaseDate!!
        )
        return RentalHistoryWithBook(rentalHistory, book)
    }
}
