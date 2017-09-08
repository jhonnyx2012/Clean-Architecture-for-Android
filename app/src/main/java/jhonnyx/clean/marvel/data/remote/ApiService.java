package jhonnyx.clean.marvel.data.remote;

import io.reactivex.Observable;
import jhonnyx.clean.marvel.data.remote.response.ComicDataWrapper;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Jhonny Barrios on 08-09-17.
 *
 * All methods that will make a request to MARVEL API
 */
public interface ApiService {
    @GET("comics?format=comic&limit=30&formatType=comic&apikey="+ApiConstants.PUBLIC_KEY)
    Observable<ComicDataWrapper> getComics(@Query("hash") String hash,
                                           @Query("ts") long ts,
                                           @Query("offset") int offset,
                                           @Query("titleStartsWith") String titleStartsWith);
}