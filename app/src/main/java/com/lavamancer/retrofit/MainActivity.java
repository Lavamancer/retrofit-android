package com.lavamancer.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    TextView usersTextView;
    public String token;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usersTextView = findViewById(R.id.usersTextView);


        findViewById(R.id.loginButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserService.postLogin(MainActivity.this);
            }
        });

        findViewById(R.id.usersButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserService.getUsers(MainActivity.this);
            }
        });


    }

    public void updateUsers(List<User> users) {
        if (users != null) {
            System.out.println("Users Size: " + users.size());
            StringBuilder text = new StringBuilder();
            for (User user : users) {
                text.append(user.getName()).append("\n");
            }
            usersTextView.setText(text);
        } else {
            Toast.makeText(this, "Error al pedir usuarios", Toast.LENGTH_SHORT).show();
        }
    }
}
