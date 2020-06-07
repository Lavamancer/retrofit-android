package com.lavamancer.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.usersTextView) TextView usersTextView;
    @BindView(R.id.loginButton) Button loginButton;
    @BindView(R.id.usersButton) Button usersButton;
    public String token;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        usersTextView = findViewById(R.id.usersTextView);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserService.postLogin(MainActivity.this);
            }
        });

        usersButton.setOnClickListener(new View.OnClickListener() {
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
