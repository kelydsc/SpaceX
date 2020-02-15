package br.com.kely.spacex.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.kely.spacex.R;
import br.com.kely.spacex.adapters.RecyclerViewLaunchesAdapter;
import br.com.kely.spacex.interfaces.RecyclerViewLaunchClickListener;
import br.com.kely.spacex.model.api.Launch;
import br.com.kely.spacex.viewmodel.LaunchViewModel;

public class MainActivity extends AppCompatActivity implements RecyclerViewLaunchClickListener {

    private RecyclerView recyclerView;
    private RecyclerViewLaunchesAdapter adapter;

    private LaunchViewModel launchViewModel;

    private List<Launch> launchList = new ArrayList<>();

    private ProgressBar progressBarBuscaLaunch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        buscarDadosApi();

        validaRetornoApi();
    }

    private void initViews() {

        progressBarBuscaLaunch = findViewById(R.id.progressBarBuscaLaunch);

        recyclerView = findViewById(R.id.recyclerviewLaunch);

        adapter = new RecyclerViewLaunchesAdapter(launchList, this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        //Adiciona o layoutManager ao recyclerview
        recyclerView.setLayoutManager(layoutManager);

        //Adiciona o adapter ao recyclerview
        recyclerView.setAdapter(adapter);

        //Inicializa classes ViewModel
        launchViewModel = ViewModelProviders.of(this).get(LaunchViewModel.class);
    }

    private void buscarDadosApi() {

        launchViewModel.getLaunches();
    }

    private void validaRetornoApi() {

        //Observable Loading
        launchViewModel.getLaunchesLoadingLiveData().observe(this, isLoading -> {
            if (isLoading) {
                progressBarBuscaLaunch.setVisibility(View.VISIBLE);
            } else {
                progressBarBuscaLaunch.setVisibility(View.GONE);
            }
        });

        launchViewModel.getLaunchesLiveData().observe(this, launchListLocal -> {

            //Valida o retorno da API
            if (!launchListLocal.isEmpty() && launchListLocal != null) {

                //Retorna os dados do Launch gravados na Api
                launchList.addAll(launchListLocal);

                adapter.updateLaunch(launchListLocal);
            } else {

                Toast.makeText(MainActivity.this.getApplicationContext(),
                        "Launch não localizado!",
                        Toast.LENGTH_LONG).show();
            }
        });

        //Observable Error
        launchViewModel.getLaunchesErrorLiveData().observe(this, throwable -> {
            Toast.makeText(getApplicationContext(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void onClick(Launch launch) {

    }
}
