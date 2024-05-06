package com.retardeddev.educonnect.data.repository

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.retardeddev.educonnect.data.model.Course
import com.retardeddev.educonnect.data.model.Notification

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "EduConnect", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_COURSES_TABLE =
            "CREATE TABLE Courses (_id INTEGER PRIMARY KEY, title TEXT, description TEXT, commencement TEXT, duration TEXT, fee TEXT, maxParticipants TEXT, branches TEXT, cid TEXT, __v INTEGER)"
        val CREATE_NOTIFICATIONS_TABLE =
            "CREATE TABLE Notifications (id INTEGER PRIMARY KEY AUTOINCREMENT, time TEXT, message TEXT)"
        db.execSQL(CREATE_COURSES_TABLE)
        db.execSQL(CREATE_NOTIFICATIONS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS Courses")
        db.execSQL("DROP TABLE IF EXISTS Notifications")
        onCreate(db)
    }

    fun addCourse(course: Course) {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put("_id", course._id.toString())
            put("title", course.title)
            put("description", course.description)
            put("commencement", course.commencement)
            put("duration", course.duration)
            put("fee", course.fee)
            put("maxParticipants", course.maxParticipants.toString())
            put("branches", course.branches.joinToString(","))
            put("cid", course.cid)
            put("__v", course.__v.toString())
        }
        db.insert("Courses", null, values)
        db.close()
    }

    fun addNotification(notification: Notification) {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put("time", notification.time)
            put("message", notification.message)
        }
        db.insert("Notifications", null, values)
        db.close()
    }

    fun getNotifications(): List<Notification> {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM Notifications", null)
        val notifications = mutableListOf<Notification>()
        if (cursor.moveToFirst()) {
            do {
                val idIndex = cursor.getColumnIndex("id")
                val timeIndex = cursor.getColumnIndex("time")
                val messageIndex = cursor.getColumnIndex("message")

                val id = if (idIndex != -1) cursor.getInt(idIndex) else 0
                val time = if (timeIndex != -1) cursor.getString(timeIndex) else ""
                val message = if (messageIndex != -1) cursor.getString(messageIndex) else ""

                notifications.add(Notification(id, time, message))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return notifications
    }
}