package com.example.doctorappointmentapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class AppointmentDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "appointments.db"
        private const val DATABASE_VERSION = 2
        private const val TABLE_NAME = "appointments"
        private const val COLUMN_ID = "id"
        private const val COLUMN_DATE = "date"
        private const val COLUMN_TIME = "time"
        private const val COLUMN_APPOINTMENT_TYPE = "appointment_type"
        private const val COLUMN_EXTRA_SERVICE = "extra_service"
        private const val COLUMN_CLINIC_WEBSITE = "clinic_website"
        private const val COLUMN_CLINIC_LOCATION = "clinic_location"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = """
        CREATE TABLE $TABLE_NAME (
            $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
            $COLUMN_DATE TEXT,
            $COLUMN_TIME TEXT,
            $COLUMN_APPOINTMENT_TYPE TEXT,
            $COLUMN_EXTRA_SERVICE INTEGER,
            $COLUMN_CLINIC_WEBSITE TEXT,
            $COLUMN_CLINIC_LOCATION TEXT
        )
    """
        db.execSQL(createTableQuery)
    }


    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        if (oldVersion < 2) { // Check if the old version is less than the new version
            db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
            onCreate(db)
        }
    }



    fun insertAppointment(
        date: String,
        time: String,
        appointmentType: String,
        extraService: Boolean,
        clinicWebsite: String,
        clinicLocation: String
    ): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_DATE, date)
            put(COLUMN_TIME, time)
            put(COLUMN_APPOINTMENT_TYPE, appointmentType)
            put(COLUMN_EXTRA_SERVICE, if (extraService) 1 else 0)
            put(COLUMN_CLINIC_WEBSITE, clinicWebsite)
            put(COLUMN_CLINIC_LOCATION, clinicLocation)
        }

        val appointmentId = db.insert(TABLE_NAME, null, values)
        db.close()

        return appointmentId
    }


    fun getAllAppointments(): List<Appointment> {
        val db = readableDatabase
        val cursor = db.query(TABLE_NAME, null, null, null, null, null, null)
        val appointments = mutableListOf<Appointment>()

        if (cursor != null) {
            Log.d("DatabaseQuery", "Cursor successfully retrieved")

            // Log column names for debugging
            val columnCount = cursor.columnCount
            for (i in 0 until columnCount) {
                Log.d("DatabaseQuery", "Column name at index $i: ${cursor.getColumnName(i)}")
            }

            while (cursor.moveToNext()) {
                try {
                    val id = cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_ID))
                    val date = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DATE))
                    val time = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TIME))
                    val appointmentType = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_APPOINTMENT_TYPE))
                    val extraService = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_EXTRA_SERVICE)) == 1
                    val clinicWebsite = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CLINIC_WEBSITE))
                    val clinicLocation = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CLINIC_LOCATION))

                    appointments.add(Appointment(id, date, time, appointmentType, extraService, clinicWebsite, clinicLocation))
                } catch (e: Exception) {
                    Log.e("DatabaseError", "Error reading row at position ${cursor.position}", e)
                }
            }
            cursor.close()
        } else {
            Log.e("DatabaseError", "Cursor is null")
        }



        return appointments
    }

    fun clearAllAppointments() {
        val db = writableDatabase
        db.delete(TABLE_NAME, null, null)
        db.close()
    }





}
