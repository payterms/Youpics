package ru.payts.youpics.mvp.model.retrofit;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

import ru.payts.youpics.mvp.model.entity.PhotoSet;

public interface IApiService {
    @GET("api")
    Observable<PhotoSet> getPhoto(@Query("key") String key);
}
