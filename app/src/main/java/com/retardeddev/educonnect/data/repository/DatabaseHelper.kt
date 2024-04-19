package com.retardeddev.educonnect.data.repository

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.retardeddev.educonnect.data.model.Course

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object{
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "EduConnectDB"
        private  const val TABLE_COURSES = "Courses"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createCoursesTable = ("CREATE TABLE " + TABLE_COURSES +
                "(" + "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "description TEXT," +
                "duration TEXT," +
                "commencementDate TEXT," +
                "fee TEXT," +
                "maxParticipants INTEGER," +
                "branches TEXT," +
                "registrationClosingDate TEXT" + ")"
                )
        db?.execSQL(createCoursesTable)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE IF EXISTS $TABLE_COURSES")
        onCreate(p0)
    }

    fun getCourseDetails(courseID: Int): Course {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_COURSES WHERE _id = ?", arrayOf(courseID.toString()))
        lateinit var course: Course
        if (cursor.moveToFirst()) {
            course = Course(
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getInt(6),
                cursor.getString(7),
                cursor.getString(8)
            )
        }
        cursor.close()
        return course
    }

    fun addCourse(course: Course) {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put("name", course.name)
            put("description", course.desc)
            put("duration", course.duration)
            put("commencementDate", course.commencementDate)
            put("fee", course.fee)
            put("maxParticipants", course.maxParticipants)
            put("branches", course.branches)
            put("registrationClosingDate", course.registrationClosingDate)
        }
        db.insert("Courses", null, values)
        db.close()
    }

    fun logAllCourses() {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_COURSES", null)
        while (cursor.moveToNext()) {
            val course = Course(
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getInt(6),
                cursor.getString(7),
                cursor.getString(8)
            )
            Log.d("DatabaseHelper", course.toString())
        }
        cursor.close()
    }
}