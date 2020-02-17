package br.com.kely.spacex.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import br.com.kely.spacex.R;
import br.com.kely.spacex.model.globaldata.GlobalData;

public class WebViewYoutubeActivity extends AppCompatActivity {

    private WebView webViewYoutube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_youtube_view);

        webViewYoutube = findViewById(R.id.webViewYoutube);
        webViewYoutube.setWebViewClient(new WebViewClient());
        webViewYoutube.loadUrl(GlobalData.getLaunch().getLinks().getVideoLink());

        WebSettings webSettings = webViewYoutube.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}
