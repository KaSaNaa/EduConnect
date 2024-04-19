package com.retardeddev.educonnect.data.model

data class Course(
    val name: String,
    val desc: String,
    val duration: String,
    val commencementDate: String,
    val fee: String,
    val maxParticipants: Int,
    val branches: String,
    val registrationClosingDate: String
)