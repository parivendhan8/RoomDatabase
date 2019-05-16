package com.example.room.Database_Room;

import androidx.room.Room;
import android.content.Context;

public class DatabaseClient {

    private Context context;
    private static DatabaseClient Instance;

    private AppDatabase appDatabase;

    private DatabaseClient(Context context)
    {
        this.context = context;
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, "DAO")
                .allowMainThreadQueries()
                .build();
    }

    public static synchronized DatabaseClient getInstance(Context context)
    {
        if (Instance == null)
        {
            Instance = new DatabaseClient(context);
        }

        return Instance;
    }


    public AppDatabase getAppDatabase()
    {
        return appDatabase;
    }
}
