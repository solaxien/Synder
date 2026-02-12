package com.synder.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [SavedSongEntity::class], version = 1, exportSchema = false)
abstract class SynderDatabase : RoomDatabase() {
    abstract fun savedSongDao(): SavedSongDao
}
