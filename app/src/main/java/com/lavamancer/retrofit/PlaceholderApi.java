package com.lavamancer.retrofit;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PlaceholderApi {

    @POST("/public/login")
    @FormUrlEncoded
    Call<Token> postLogin(@Field("username") String username, @Field("password") String password);

    @GET("/public/users")
    Call<List<User>> getUsers(@Header("authorization") String token);

}
