package com.example.room.Database_Room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.room.Database_Room.Entities.Task;
import com.example.room.Database_Room.Entities.TaskDao;



@Database(entities = {Task.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract TaskDao taskDao();


}
