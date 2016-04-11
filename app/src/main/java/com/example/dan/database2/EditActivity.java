package com.example.dan.database2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {
    DBHelper dbHelper;
    User user;
    EditText editName, editEmail;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        editName = (EditText) findViewById(R.id.editName);
        editEmail = (EditText) findViewById(R.id.editEmail);
        dbHelper = new DBHelper(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "saved", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                user.setName(editName.getText().toString());
                user.setEmail(editEmail.getText().toString());
                if(position == -1){
                    dbHelper.addUser(user);
                }else
                    dbHelper.updateUser(user);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        position = getIntent().getIntExtra(UsersAdapter.EXTRA_POSITION, -1);
        if(position == -1){  // comming from the add button
            user = new User("","");
        }else {
            user = dbHelper.getUser(position + 1);
            editName.setText(user.getName());
            editEmail.setText(user.getEmail());
        }
    }

}
