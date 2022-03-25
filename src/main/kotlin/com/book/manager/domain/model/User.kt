package com.book.manager.domain.model

import com.book.manager.domain.enum.RoleType

data class User(
    val userProfile: UserProfile,
    val email: String,
    val password: String,
    val roleType: RoleType,
)
