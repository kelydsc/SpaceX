package br.com.kely.spacex.view;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import br.com.kely.spacex.R;
import br.com.kely.spacex.model.globaldata.GlobalData;

public class WebViewArticleActivity extends AppCompatActivity {

    private WebView webViewArticle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_article);

        webViewArticle = findViewById(R.id.webViewArticle);
        webViewArticle.setWebViewClient(new WebViewClient());
        webViewArticle.loadUrl(GlobalData.getLaunch().getLinks().getArticleLink());

        WebSettings webSettings = webViewArticle.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}
