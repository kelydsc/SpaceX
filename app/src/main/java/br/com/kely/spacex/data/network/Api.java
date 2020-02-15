package br.com.kely.spacex.data.network;

import java.util.List;

import br.com.kely.spacex.model.api.Launch;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface Api {

    //Lista de Launches
    @GET("launches")
    Single<List<Launch>> getLaunches();
}
