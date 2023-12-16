package com.parstasmim.mylibrary.datasource.db

import androidx.room.*

interface BaseDao<T> {

    /**
     * Insert an object in the database.
     *
     * @param obj the object to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(obj: T): Long

    /**
     * Insert an array of objects in the database.
     *
     * @param obj the objects to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg obj: T): List<Long>

    /**
     * Insert a list of objects in the database.
     *
     * @param obj the objects to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(obj: List<T>): List<Long>

    /**
     * Update an object from the database. Finding the object using its primary key
     *
     * @param obj the object to be updated
     */
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(obj: T)

    /**
     * Update a list of objects from the database. Finding the object using its primary key
     *
     * @param obj the objects to be updated
     */
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(obj: List<T>)

    /**
     * Delete an object from the database. Finding the object using its primary key
     *
     * @param obj the object to be deleted
     */
    @Delete
    abstract fun delete(obj: T)

}
