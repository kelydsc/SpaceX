package br.com.kely.spacex.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.squareup.picasso.Picasso;

import br.com.kely.spacex.R;
import br.com.kely.spacex.model.globaldata.GlobalData;

public class DetalheLaunchActivity extends AppCompatActivity {

    private GlobalData globalData;

    private ImageView imageViewDetalheLaunch;
    private ImageView imageViewShare;
    private ImageView imageViewVideo;
    private ImageView imageViewLink;

    private TextView textViewDetalheLaunchMissionName;
    private TextView textViewDetalheLaunchFlightNumber;
    private TextView textViewDetalheLaunchRocketId;
    private TextView textViewDetalheLaunchRocketName;
    private TextView textViewDetalheLaunchRocketType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_launch);

        //Seta a toolbar e o botão voltar(back)
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("Detalhe do lançamento");

        // Inicializa as views que serão utilizadas na activity
        initViews();

        //Exibe os dados na tela
        exibeDados();

        //Metodo para acessar os aplicativos de compartilhamento de dados
        compartilharDadosLaunch();

        //visualiza video do Youtube
        visualizarVideo();

        //visualiza article link
        visualizarArtigo();
    }

    private void initViews() {

        imageViewDetalheLaunch = findViewById(R.id.imageViewDetalheLaunch);
        imageViewShare = findViewById(R.id.imageViewShare);
        imageViewVideo = findViewById(R.id.imageViewVideo);
        imageViewLink = findViewById(R.id.imageViewLink);

        textViewDetalheLaunchMissionName = findViewById(R.id.textViewDetalheLaunchMissionName);
        textViewDetalheLaunchFlightNumber = findViewById(R.id.textViewDetalheLaunchFlightNumber);
        textViewDetalheLaunchRocketId = findViewById(R.id.textViewDetalheLaunchRocketId);
        textViewDetalheLaunchRocketName = findViewById(R.id.textViewDetalheLaunchRocketName);
        textViewDetalheLaunchRocketType = findViewById(R.id.textViewDetalheLaunchRocketType);
    }

    private void exibeDados() {

        if (GlobalData.getLaunch().getLinks().getMissionPatchSmall() != null) {
            Picasso.get().setIndicatorsEnabled(true);
            Picasso.get()
                    .load(GlobalData.getLaunch().getLinks().getMissionPatchSmall())
                    .error(R.mipmap.ic_launcher)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(imageViewDetalheLaunch);
        }

        textViewDetalheLaunchMissionName.setText(GlobalData.getLaunch().getMissionName());

        textViewDetalheLaunchFlightNumber.setText(GlobalData.getLaunch().getFlightNumber());

        textViewDetalheLaunchRocketId.setText(GlobalData.getLaunch().getRocket().getRocketId());

        textViewDetalheLaunchRocketName.setText(GlobalData.getLaunch().getRocket().getRocketName());

        textViewDetalheLaunchRocketType.setText(GlobalData.getLaunch().getRocket().getRocketType());
    }

    private void compartilharDadosLaunch() {

        imageViewShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Acao de envio na intencao de chamar outra Actitivity
                Intent intentCompartilhar = new Intent(Intent.ACTION_SEND);

                //Envia texto no compartilhamento
                intentCompartilhar.putExtra(Intent.EXTRA_TEXT, "Dados da Api SpaceX:" + "\n" +
                        "\nMission Name: " + GlobalData.getLaunch().getMissionName() + "\n" +
                        "\nFlight Number: " + GlobalData.getLaunch().getFlightNumber() + "\n" +
                        "\nRocket Id: " + GlobalData.getLaunch().getRocket().getRocketId() + "\n" +
                        "\nRocket Name: " + GlobalData.getLaunch().getRocket().getRocketName() + "\n" +
                        "\nRocket Type: " + GlobalData.getLaunch().getRocket().getRocketType() + "\n" +
                        "\nArticle Link: " + GlobalData.getLaunch().getLinks().getArticleLink() + "\n" +
                        "\nWikipedia: " + GlobalData.getLaunch().getLinks().getWikipedia());

                //tipo de compartilhamento
                intentCompartilhar.setType("text/plain");

                //Mostra os aplicativos disponiveis para compartilhamento de dados
                Intent intentChooser = Intent.createChooser(
                        intentCompartilhar, "Compartilhar via:");

                //Start na Activity de compartilhamento
                startActivity(intentChooser);
            }
        });
    }

    private void visualizarVideo() {

        imageViewVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(DetalheLaunchActivity.this, WebViewYoutubeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void visualizarArtigo() {

        imageViewLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(DetalheLaunchActivity.this, WebViewArticleActivity.class);
                startActivity(intent);
            }
        });
    }
}
