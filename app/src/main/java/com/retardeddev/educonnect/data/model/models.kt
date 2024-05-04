package com.retardeddev.educonnect.data.model

data class Course(
    val _id: String,
    val title: String,
    val description: String,
    val commencement: String,
    val duration: String,
    val fee: String,
    val maxParticipants: Int,
    val branches: List<String>,
    val cid: Int,
    val __v: Int
)

data class Notification(
    val id: Int,
    val time: String,
    val message: String
)