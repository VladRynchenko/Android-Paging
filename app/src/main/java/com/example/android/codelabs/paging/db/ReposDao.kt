package com.example.android.codelabs.paging.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android.codelabs.paging.model.Repo

@Dao
interface ReposDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(repos: List<Repo>)

    @Query("Select * From repos where name like :queryString or description like :queryString order by stars desc, name asc ")
    fun reposByName(queryString: String): PagingSource<Int, Repo>

    @Query("delete from repos")
    suspend fun clearRepos()
}