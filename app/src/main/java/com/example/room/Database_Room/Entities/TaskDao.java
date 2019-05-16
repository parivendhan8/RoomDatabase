package com.example.room.Database_Room.Entities;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TaskDao {

    @Query("SElECT * FROM task")
    List<Task> getAll();

    @Insert
    void insert(Task task);

    @Delete
    void Delete(Task task);

    @Update
    void Upadte(Task task);

}
