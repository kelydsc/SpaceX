package br.com.kely.spacex.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.com.kely.spacex.model.api.Launch;
import br.com.kely.spacex.repository.LaunchRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static br.com.kely.spacex.util.Util.isNetworkConnected;

public class LaunchViewModel extends AndroidViewModel {

    private MutableLiveData<List<Launch>> launchesLiveData = new MutableLiveData<>();
    private MutableLiveData<Throwable> errorLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> loadingLiveData = new MutableLiveData<>();

    private CompositeDisposable disposable = new CompositeDisposable();
    private LaunchRepository repository = new LaunchRepository();

    public LaunchViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Launch>> getLaunchesLiveData() {
        return launchesLiveData;
    }

    public LiveData<Boolean> getLaunchesLoadingLiveData() {
        return loadingLiveData;
    }

    public LiveData<Throwable> getLaunchesErrorLiveData() {
        return errorLiveData;
    }

    //Busca a lista de Launches
    public void getLaunches(String item, int pagina, int limite, String ordem) {

        if (isNetworkConnected(getApplication())) {
            getApiLaunches(item, pagina, limite, ordem);
        }
    }

    private void getApiLaunches(String item, int pagina, int limite, String ordem) {
        disposable.add(
                repository.getLaunches(item, pagina, limite, ordem)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> loadingLiveData.setValue(true))
                        .doAfterTerminate(() -> loadingLiveData.setValue(false))
                        .subscribe(launches -> launchesLiveData.setValue(launches)
                                , throwable -> errorLiveData.setValue(throwable))
        );
    }

    //Busca a lista de Launches by Rocket
    public void getLaunchesbyRocket(String rocketId) {

        if (isNetworkConnected(getApplication())) {
            getApiLaunchesbyRocket(rocketId);
        }
    }

    private void getApiLaunchesbyRocket(String rocketId) {
        disposable.add(
                repository.getLaunchesbyRocket(rocketId)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> loadingLiveData.setValue(true))
                        .doAfterTerminate(() -> loadingLiveData.setValue(false))
                        .subscribe(launches -> launchesLiveData.setValue(launches)
                                , throwable -> errorLiveData.setValue(throwable))
        );
    }

    // Limpa as chamadas no RX
    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }


}
