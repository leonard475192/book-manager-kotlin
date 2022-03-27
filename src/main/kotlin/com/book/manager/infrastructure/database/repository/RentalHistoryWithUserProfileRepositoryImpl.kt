package com.book.manager.infrastructure.database.repository

import com.book.manager.domain.model.RentalHistory
import com.book.manager.domain.model.RentalHistoryWithUserProfile
import com.book.manager.domain.model.UserProfile
import com.book.manager.domain.repository.RentalHistoryWithUserProfileRepository
import com.book.manager.infrastructure.database.mapper.custom.RentalHistoryWithUserMapper
import com.book.manager.infrastructure.database.mapper.custom.selectByBookId
import com.book.manager.infrastructure.database.record.custom.RentalHistoryWithUserRecord
import org.springframework.stereotype.Repository

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@Repository
class RentalHistoryWithUserProfileRepositoryImpl(
    private val rentalHistoryWithUserMapper: RentalHistoryWithUserMapper
) : RentalHistoryWithUserProfileRepository {
    override fun fetchRentalHistory(bookId: Long): List<RentalHistoryWithUserProfile> {
        return rentalHistoryWithUserMapper.selectByBookId(bookId).map { toModel(it) }
    }

    private fun toModel(record: RentalHistoryWithUserRecord) : RentalHistoryWithUserProfile {
        val rentalHistory = RentalHistory(
            record.id!!,
            record.rentalDatetime!!,
            record.returnDatetime!!
        )
        val userProfile = UserProfile(
            record.userId!!,
            record.name!!
        )
        return RentalHistoryWithUserProfile(rentalHistory, userProfile)
    }
}
