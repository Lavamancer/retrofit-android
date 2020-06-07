package com.lavamancer.retrofit;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class UserService {


    public static void postLogin(final MainActivity mainActivity) {
        new AsyncTask<Void, Void, Token>() {
            @Override
            protected Token doInBackground(Void... voids) {
                try {
                    return RetrofitTool.getInstance().api.postLogin("juan", "1234")
                            .execute().body();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Token token) {
                mainActivity.token = token.getAccessToken();
            }
        }.execute();
    }

    public static void getUsers(final MainActivity mainActivity) {
        new AsyncTask<Void, Void, List<User>>() {
            @Override
            protected List<User> doInBackground(Void... voids) {
                try {
                    return RetrofitTool.getInstance().api.getUsers(mainActivity.token).execute().body();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(List<User> users) {
                mainActivity.updateUsers(users);
            }
        }.execute();
    }

}
