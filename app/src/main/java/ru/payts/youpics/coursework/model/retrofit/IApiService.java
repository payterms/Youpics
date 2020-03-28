package ru.payts.youpics.coursework.model.retrofit;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.payts.youpics.coursework.model.entity.PhotoSet;

public interface IApiService {
    @GET("api")
    Observable<PhotoSet> getPhotoSet(@Query("key") String key,  //Your API key:
                                     @Query("q") String query,  //A URL encoded search term. If omitted, all images are returned. This value may not exceed 100 characters.
                                     @Query("page") int page,    //Returned search results are paginated. Use this parameter to select the page number.
                                     @Query("per_page") int per_page,
                                     @Query("colors") String colors); //Filter images by color properties. A comma separated list of values may be used to select multiple properties.
}
