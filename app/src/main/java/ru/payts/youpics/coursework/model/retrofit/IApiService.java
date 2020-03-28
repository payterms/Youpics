package ru.payts.youpics.coursework.model.retrofit;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.payts.youpics.coursework.model.entity.PhotoSet;

public interface IApiService {
    @GET("api")
    Observable<PhotoSet> getPhotoSet(@Query("key") String key,  //Your API key:
                                     @Query("page") int page,    //Returned search results are paginated. Use this parameter to select the page number.
                                     @Query("per_page") int per_page); //Determine the number of results per page. Accepted values: 3 - 200 Default: 20
}
