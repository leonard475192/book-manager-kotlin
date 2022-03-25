/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.book.manager.infrastructure.database.mapper

import com.book.manager.infrastructure.database.mapper.RentalHistoryDynamicSqlSupport.RentalHistory
import com.book.manager.infrastructure.database.mapper.RentalHistoryDynamicSqlSupport.RentalHistory.bookId
import com.book.manager.infrastructure.database.mapper.RentalHistoryDynamicSqlSupport.RentalHistory.id
import com.book.manager.infrastructure.database.mapper.RentalHistoryDynamicSqlSupport.RentalHistory.rentalDatetime
import com.book.manager.infrastructure.database.mapper.RentalHistoryDynamicSqlSupport.RentalHistory.returnDatetime
import com.book.manager.infrastructure.database.mapper.RentalHistoryDynamicSqlSupport.RentalHistory.userId
import com.book.manager.infrastructure.database.record.RentalHistoryRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun RentalHistoryMapper.count(completer: CountCompleter) =
    countFrom(this::count, RentalHistory, completer)

fun RentalHistoryMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, RentalHistory, completer)

fun RentalHistoryMapper.deleteByPrimaryKey(id_: Long) =
    delete {
        where(id, isEqualTo(id_))
    }

fun RentalHistoryMapper.insert(record: RentalHistoryRecord) =
    insert(this::insert, record, RentalHistory) {
        map(id).toProperty("id")
        map(bookId).toProperty("bookId")
        map(userId).toProperty("userId")
        map(rentalDatetime).toProperty("rentalDatetime")
        map(returnDatetime).toProperty("returnDatetime")
    }

fun RentalHistoryMapper.insertMultiple(records: Collection<RentalHistoryRecord>) =
    insertMultiple(this::insertMultiple, records, RentalHistory) {
        map(id).toProperty("id")
        map(bookId).toProperty("bookId")
        map(userId).toProperty("userId")
        map(rentalDatetime).toProperty("rentalDatetime")
        map(returnDatetime).toProperty("returnDatetime")
    }

fun RentalHistoryMapper.insertMultiple(vararg records: RentalHistoryRecord) =
    insertMultiple(records.toList())

fun RentalHistoryMapper.insertSelective(record: RentalHistoryRecord) =
    insert(this::insert, record, RentalHistory) {
        map(id).toPropertyWhenPresent("id", record::id)
        map(bookId).toPropertyWhenPresent("bookId", record::bookId)
        map(userId).toPropertyWhenPresent("userId", record::userId)
        map(rentalDatetime).toPropertyWhenPresent("rentalDatetime", record::rentalDatetime)
        map(returnDatetime).toPropertyWhenPresent("returnDatetime", record::returnDatetime)
    }

private val columnList = listOf(id, bookId, userId, rentalDatetime, returnDatetime)

fun RentalHistoryMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, RentalHistory, completer)

fun RentalHistoryMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, RentalHistory, completer)

fun RentalHistoryMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, RentalHistory, completer)

fun RentalHistoryMapper.selectByPrimaryKey(id_: Long) =
    selectOne {
        where(id, isEqualTo(id_))
    }

fun RentalHistoryMapper.update(completer: UpdateCompleter) =
    update(this::update, RentalHistory, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: RentalHistoryRecord) =
    apply {
        set(id).equalTo(record::id)
        set(bookId).equalTo(record::bookId)
        set(userId).equalTo(record::userId)
        set(rentalDatetime).equalTo(record::rentalDatetime)
        set(returnDatetime).equalTo(record::returnDatetime)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: RentalHistoryRecord) =
    apply {
        set(id).equalToWhenPresent(record::id)
        set(bookId).equalToWhenPresent(record::bookId)
        set(userId).equalToWhenPresent(record::userId)
        set(rentalDatetime).equalToWhenPresent(record::rentalDatetime)
        set(returnDatetime).equalToWhenPresent(record::returnDatetime)
    }

fun RentalHistoryMapper.updateByPrimaryKey(record: RentalHistoryRecord) =
    update {
        set(bookId).equalTo(record::bookId)
        set(userId).equalTo(record::userId)
        set(rentalDatetime).equalTo(record::rentalDatetime)
        set(returnDatetime).equalTo(record::returnDatetime)
        where(id, isEqualTo(record::id))
    }

fun RentalHistoryMapper.updateByPrimaryKeySelective(record: RentalHistoryRecord) =
    update {
        set(bookId).equalToWhenPresent(record::bookId)
        set(userId).equalToWhenPresent(record::userId)
        set(rentalDatetime).equalToWhenPresent(record::rentalDatetime)
        set(returnDatetime).equalToWhenPresent(record::returnDatetime)
        where(id, isEqualTo(record::id))
    }