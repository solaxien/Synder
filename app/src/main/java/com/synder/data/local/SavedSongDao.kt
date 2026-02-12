package com.synder.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SavedSongDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(song: SavedSongEntity)

    @Query("SELECT * FROM saved_songs ORDER BY savedAt DESC")
    fun observeSavedSongs(): Flow<List<SavedSongEntity>>
}
