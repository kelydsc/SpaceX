package br.com.kely.spacex.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
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

    private SearchView searchViewLaunch;

    private RecyclerView recyclerView;
    private RecyclerViewLaunchesAdapter adapter;

    private LaunchViewModel launchViewModel;

    private List<Launch> launchList = new ArrayList<>();

    private ProgressBar progressBarBuscaLaunch;

    //pagina atual
    private int pagina = 0;

    //limite de pagins
    private int limite = 10;

    private String itemBusca = "Falcon";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        //busca dados da Api
        launchViewModel.getLaunches(itemBusca, pagina, limite);

        //Observable Loading
        launchViewModel.getLaunchesLoadingLiveData().observe(this, isLoading -> {
            if (isLoading) {
                progressBarBuscaLaunch.setVisibility(View.VISIBLE);
            } else {
                progressBarBuscaLaunch.setVisibility(View.GONE);
            }
        });

        //valida retorno da api
        launchViewModel.getLaunchesLiveData().observe(this, launchList -> adapter.updateLaunch(launchList));

        searchViewLaunch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                itemBusca = query;
                adapter.clear();
                launchViewModel.getLaunches(itemBusca, pagina, limite);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.length() > 3){
                    itemBusca = newText;
                    adapter.clear();
                    launchViewModel.getLaunches(itemBusca, pagina, limite);
                }
                return false;
            }
        });

        //Observable Error
        launchViewModel.getLaunchesErrorLiveData().observe(this, throwable -> {
            Toast.makeText(getApplicationContext(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
        });

    }

    private void initViews() {

        searchViewLaunch = findViewById(R.id.searchViewLaunch);

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

        setScrollListener();
    }

    private void setScrollListener() {

        // o  recyclerview é o responsável por saber quando estamos ou não no final
        // da listagem dos itens, e para isso adicionamos o método addOnScrollListener 
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            // o método onScrolled é onde validamos nossa páginação
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                // primeiro pegamos o layoutmanager que nos fornece a quantidade  de itens que a lista possue  
                LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();

                int totalItemCount = manager.getItemCount();
                int lastVisible = manager.findLastVisibleItemPosition();

                // aqui avaliamos se os últimos itens estão sendo mostrados na tela
                boolean fimFoiEncontrado = lastVisible + 5 >= totalItemCount;

                // Aqui avaliamos se estamos no final da lista e se a página que  estamos 
                // é menos que o número de páginas que podemos requisitar 
                // caso seja verdadeiro acrescentamos +1 no número de página e fazemos 
                // uma nova requisição passando o novo número de página
                if (totalItemCount > 0 && fimFoiEncontrado) {
                    pagina++;
                    launchViewModel.getLaunches(itemBusca, pagina, limite);
                }
            }
        });
    }

    @Override
    public void onClick(Launch launch) {

    }
}
