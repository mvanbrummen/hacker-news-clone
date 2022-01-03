package com.mvanbrummen.hackernewsclone.user

import com.mvanbrummen.hackernewsclone.exception.UserNameNotFoundException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val userEntity =
            userRepository.getUserByUsername(username) ?: throw UserNameNotFoundException("User $username not found")

        return HnUserDetails(
            username = username,
            password = userEntity.passwordHash ?: throw IllegalStateException("Password not set for user $username")
        )
    }
}