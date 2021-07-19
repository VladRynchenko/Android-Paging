package com.example.android.codelabs.paging.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import retrofit2.http.DELETE

@Dao
interface RemoteKeysDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKey: List<RemoteKeys>)

    @Query("DELETE from remote_keys")
    suspend fun clearKeys()

    @Query("SELECT * FROM remote_keys WHERE repoId= :repoId")
    suspend fun remoteKeysRepoId(repoId: Long): RemoteKeys?

}