package br.com.kely.spacex.data.network;

import java.util.List;

import br.com.kely.spacex.model.api.Launch;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    //Lista de Launches
    @GET("launches")
    Observable<List<Launch>> getLaunches(@Query("q") String item,
                                         @Query("offset") int pagina,
                                         @Query("limit") int limite,
                                         @Query("sort") String ordem);

    //Lista de Launches by Rocket
    @GET("launches")
    Observable<List<Launch>> getLaunchesbyRocket(@Query("rocket_id") String rocketId);
}
