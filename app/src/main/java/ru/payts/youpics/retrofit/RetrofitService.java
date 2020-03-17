package ru.payts.youpics.retrofit;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitService {
    @GET("/users/{user}")
    Observable<UsrProfile> getUser(@Path("user") String user);
}
