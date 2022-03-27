package com.book.manager.infrastructure.database.mapper.custom

import com.book.manager.infrastructure.database.mapper.BookDynamicSqlSupport.Book
import com.book.manager.infrastructure.database.mapper.RentalHistoryDynamicSqlSupport.RentalHistory
import com.book.manager.infrastructure.database.record.custom.RentalHistoryWithBookRecord
import org.mybatis.dynamic.sql.SqlBuilder.equalTo
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.SqlBuilder.select
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.from


private val columnList = listOf(
    RentalHistory.id,
    RentalHistory.bookId,
    Book.title,
    Book.author,
    Book.releaseDate,
    RentalHistory.rentalDatetime,
    RentalHistory.returnDatetime
)

fun RentalHistoryWithBookMapper.select(): List<RentalHistoryWithBookRecord> {
    val selectStatement = select(columnList).from(RentalHistory, "h") {
        leftJoin(Book, "b") {
            on(RentalHistory.bookId, equalTo(Book.id))
        }
    }
    return selectMany(selectStatement)
}

fun RentalHistoryWithBookMapper.selectByUserId(userId_: Long): List<RentalHistoryWithBookRecord> {
    val selectStatement = select(columnList).from(RentalHistory, "h") {
        leftJoin(Book, "b") {
            on(RentalHistory.bookId, equalTo(Book.id))
        }
        where(RentalHistory.userId, isEqualTo(userId_))
    }
    return selectMany(selectStatement)
}

fun RentalHistoryWithBookMapper.selectByPrimaryKey(id_: Long): RentalHistoryWithBookRecord? {
    val selectStatement = select(columnList).from(RentalHistory, "h") {
        leftJoin(Book, "b") {
            on(RentalHistory.bookId, equalTo(Book.id))
        }
        where(RentalHistory.id, isEqualTo(id_))
    }
    return selectOne(selectStatement)
}
