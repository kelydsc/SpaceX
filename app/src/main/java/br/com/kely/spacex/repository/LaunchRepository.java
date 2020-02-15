package br.com.kely.spacex.repository;

import java.util.List;

import br.com.kely.spacex.data.network.ApiService;
import br.com.kely.spacex.model.api.Launch;
import io.reactivex.Observable;

public class LaunchRepository {

    //Retorna os dados da Api - SpaceX
    public Observable<List<Launch>> getLaunches(String item, int pagina, int limite) {
        return ApiService.getApiService().getLaunches(item, pagina, limite);
    }
}
