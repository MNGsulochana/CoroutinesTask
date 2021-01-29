package com.example.coroutinesample.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.coroutinesample.datamodel.PostModelItem
import dagger.Provides


@Dao

interface PostDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPosts(postModelItem: List<PostModelItem>?)

  /*  @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertPost(postModelItem:PostModelItem)
*/
    @Query("Select * from PostItems")
    suspend fun getAllPosts():List<PostModelItem>

    @Query("DELETE FROM PostItems WHERE id = :id")
    suspend fun deleteByUserId(id: Int)
}