package com.home.ilemus.fnot;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.logging.Handler;


public class HomeActivity extends AppCompatActivity {
    private int ProgressStatus = 0;
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        progress = (ProgressBar) findViewById(R.id.progressBar);
        new Thread(new Runnable(){
            public void run() {
                while (ProgressStatus < 100) {
                    ProgressStatus += 10;
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progress.setProgress(ProgressStatus);
                }
            }
        }).start();
        Intent intent = getIntent();
        String toDisplay = intent.getStringExtra(MainActivity.EXTRA_STRING);
        TextView text = (TextView)findViewById(R.id.textView);
        text.setText("Welcome " + toDisplay);
    }

}
