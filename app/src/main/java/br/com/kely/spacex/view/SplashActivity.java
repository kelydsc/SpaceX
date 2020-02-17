package br.com.kely.spacex.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

import br.com.kely.spacex.R;

public class SplashActivity extends AppCompatActivity {

    private ImageView imageViewSpash;
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imageViewSpash = findViewById(R.id.imageViewSpash);

        imageViewSpash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                jump();
            }
        });

        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                jump();
            }
        }, 3000);
    }

    private void jump() {

        timer.cancel();

        Intent intent = new Intent(SplashActivity.this, MainActivity.class);

        startActivity(intent);

        finish();
    }
}
