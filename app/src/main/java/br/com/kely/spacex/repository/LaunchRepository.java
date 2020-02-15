package br.com.kely.spacex.repository;

import java.util.List;

import br.com.kely.spacex.data.network.ApiService;
import br.com.kely.spacex.model.api.Launch;
import io.reactivex.Single;

public class LaunchRepository {

    //Retorna os dados da Api - SpaceX
    public Single<List<Launch>> getLaunches() {
        return ApiService.getApiService().getLaunches();
    }
}
