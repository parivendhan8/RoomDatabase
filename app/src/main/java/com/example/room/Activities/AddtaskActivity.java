package com.example.room.Activities;

import android.content.Intent;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.room.Database_Room.DatabaseClient;
import com.example.room.Database_Room.Entities.Task;
import com.example.room.R;
import com.example.room.databinding.AddTasksBinding;

public class AddtaskActivity extends AppCompatActivity {

    private EditText editTextTask;
    private EditText editTextDesc;
    private EditText editTextFinishBy;
    private Button buttonsave;
    private AddTasksBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_tasks);

        binding = DataBindingUtil.setContentView(this, R.layout.add_tasks);



        this.buttonsave = (Button) findViewById(R.id.button_save);
        this.editTextFinishBy = (EditText) findViewById(R.id.editTextFinishBy);
        this.editTextDesc = (EditText) findViewById(R.id.editTextDesc);
        this.editTextTask = (EditText) findViewById(R.id.editTextTask);

//        buttonsave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                saveData();
//            }
//        });


    }


    private void saveData()
    {


        final String sTask = editTextTask.getText().toString().trim();
        final String sDesc = editTextDesc.getText().toString().trim();
        final String sFinishBy = editTextFinishBy.getText().toString().trim();

        if (sTask.isEmpty()) {
            editTextTask.setError("Task required");
            editTextTask.requestFocus();
            return;
        }

        if (sDesc.isEmpty()) {
            editTextDesc.setError("Desc required");
            editTextDesc.requestFocus();
            return;
        }

        if (sFinishBy.isEmpty()) {
            editTextFinishBy.setError("Finish by required");
            editTextFinishBy.requestFocus();
            return;
        }


        Task task = new Task();
        task.setTask(sTask);
        task.setDesc(sDesc);
        task.setFinishBy(sFinishBy);
        task.setFinished(false);

        DatabaseClient.getInstance(getApplicationContext()).getAppDatabase().taskDao().insert(task);


        finish();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();

//        class SaveTask extends AsyncTask<Void, Void, Void>{
//
//            @Override
//            protected Void doInBackground(Void... voids) {
//
//
//                return null;
//            }
//
//            @Override
//            protected void onPostExecute(Void aVoid) {
//                super.onPostExecute(aVoid);
//
//
//            }
//
//
//        }
//
//        SaveTask st = new SaveTask();
//        st.execute();

    }

    public class Add_ViewModel{


    }




}
