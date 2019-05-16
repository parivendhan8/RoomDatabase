package com.example.room.Activities;

import android.content.Intent;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import com.example.room.Database_Room.DatabaseClient;
import com.example.room.Database_Room.Entities.Task;
import com.example.room.R;
import com.example.room.Adapter.TasksAdapter;
import com.example.room.databinding.ActivityMainBinding;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton floatingbuttonadd;
    private RecyclerView recyclerviewtasks;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        floatingbuttonadd = (FloatingActionButton) findViewById(R.id.floating_button_add);
        recyclerviewtasks = (RecyclerView) findViewById(R.id.recyclerview_tasks);
        recyclerviewtasks.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        getTasks();

       floatingbuttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AddtaskActivity.class));
            }
        });

    }

    private void getTasks() {

        List<Task> taskList = DatabaseClient
                .getInstance(getApplicationContext())
                .getAppDatabase()
                .taskDao()
                .getAll();

        TasksAdapter adapter = new TasksAdapter(MainActivity.this, taskList);
        recyclerviewtasks.setAdapter(adapter);

//        class GetTask extends AsyncTask<Void, Void, List<Task>>{
//
//            @Override
//            protected List<Task> doInBackground(Void... voids) {
//
//
//
//                return taskList;
//            }
//
//            @Override
//            protected void onPostExecute(List<Task> tasks) {
//                super.onPostExecute(tasks);
//
//
//
//            }
//        }

//        GetTask getTask = new GetTask();
//        getTask.execute();


    }


}
