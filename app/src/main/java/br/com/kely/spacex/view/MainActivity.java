package br.com.kely.spacex.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.kely.spacex.R;
import br.com.kely.spacex.adapters.RecyclerViewLaunchesAdapter;
import br.com.kely.spacex.interfaces.RecyclerViewLaunchClickListener;
import br.com.kely.spacex.model.api.Launch;
import br.com.kely.spacex.model.globaldata.GlobalData;
import br.com.kely.spacex.viewmodel.LaunchViewModel;

public class MainActivity extends AppCompatActivity implements RecyclerViewLaunchClickListener {

    private SearchView searchViewLaunch;

    private RecyclerView recyclerView;
    private RecyclerViewLaunchesAdapter adapter;

    private LaunchViewModel launchViewModel;

    private List<Launch> launchList = new ArrayList<>();

    private ProgressBar progressBarBuscaLaunch;

    //offset = A partir de que registro começa a página
    private int pagina = 0;

    //limit = Quantidade de registros por página
    private int limite = 50;

    private String itemBusca = "Falcon";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Seta a toolbar e o botão voltar(back)
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("SpaceX");

        initViews();

        //busca dados da Api - All Launches
        launchViewModel.getLaunches(itemBusca, pagina, limite, "");

        ocultaTeclado();

        //Valida retorno da Api
        validaRetornoApi();

        //Busca Launch por rocket name ou rocket type
        validaBuscaLaunch();
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

    private void ocultaTeclado() {

        //Oculta o teclado no momento em que o usuário aperta um botão
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (imm.isActive())
            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }

    private void validaRetornoApi() {

        ocultaTeclado();

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

                //Retorna os dados do Produto gravados na Api
                launchList.addAll(launchListLocal);

                adapter.updateLaunch(launchList);
            } else {

                Toast.makeText(getApplicationContext(),
                        "Lançamento não localizado!",
                        Toast.LENGTH_LONG).show();
            }
        });

        //Observable Error
        launchViewModel.getLaunchesErrorLiveData().observe(this, throwable -> {
            Toast.makeText(getApplicationContext(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
        });
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
                    launchViewModel.getLaunches(itemBusca, pagina, limite, "");
                }
            }
        });
    }

    private void validaBuscaLaunch() {

        searchViewLaunch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                ocultaTeclado();

                if (itemBusca.length() > 6) {

                    itemBusca = query;
                    adapter.clear();

                    //busca launch
                    launchViewModel.getLaunchesbyRocket(itemBusca);

                } else {
                    Toast.makeText(getApplicationContext(),
                            "Digite pelo menos 7 caracteres para pesquisar o foguete ",
                            Toast.LENGTH_LONG).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                if (newText.length() > 6) {

                    itemBusca = newText;
                    adapter.clear();

                    ocultaTeclado();

                    //busca launch
                    launchViewModel.getLaunchesbyRocket(itemBusca);
                }
                return false;
            }

        });
    }

    @Override
    public void onClick(Launch launch) {

        //Guarda na classe Global os dados do Launch selecionado na lista
        GlobalData.setLaunch(launch);

        //Chama a tela Detalhe
        Intent intent = new Intent(MainActivity.this, DetalheLaunchActivity.class);
        startActivity(intent);

    }
}
