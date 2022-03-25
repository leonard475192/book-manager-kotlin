package com.book.manager.infrastructure.database.mapper.custom

import com.book.manager.infrastructure.database.mapper.RentalHistoryDynamicSqlSupport.RentalHistory
import com.book.manager.infrastructure.database.mapper.UserDynamicSqlSupport.User
import com.book.manager.infrastructure.database.record.custom.RentalHistoryWithUserRecord
import org.mybatis.dynamic.sql.SqlBuilder.equalTo
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.SqlBuilder.select
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.from


private val columnList = listOf(
    RentalHistory.id,
    RentalHistory.userId,
    User.name,
    RentalHistory.rentalDatetime,
    RentalHistory.returnDatetime
)

fun RentalHistoryWithUserMapper.select(): List<RentalHistoryWithUserRecord> {
    val selectStatement = select(columnList).from(RentalHistory, "h") {
        leftJoin(User, "u") {
            on(RentalHistory.userId, equalTo(User.id))
        }
    }
    return selectMany(selectStatement)
}

fun RentalHistoryWithUserMapper.selectByBookId(bookId_: Long): List<RentalHistoryWithUserRecord> {
    val selectStatement = select(columnList).from(RentalHistory, "h") {
        leftJoin(User, "u") {
            on(RentalHistory.userId, equalTo(User.id))
        }
        where(RentalHistory.bookId, isEqualTo(bookId_))
    }
    return selectMany(selectStatement)
}

fun RentalHistoryWithUserMapper.selectByPrimaryKey(id_: Long): RentalHistoryWithUserRecord? {
    val selectStatement = select(columnList).from(RentalHistory, "h") {
        leftJoin(User, "u") {
            on(RentalHistory.userId, equalTo(User.id))
        }
        where(RentalHistory.id, isEqualTo(id_))
    }
    return selectOne(selectStatement)
}
