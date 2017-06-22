package com.jones.jonesmanlapazapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Main_Activity extends AppCompatActivity {

    private Button buttonSingle, buttonVersus, buttonCoop, buttonScores, buttonSettings;
    private ImageView imageViewClock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSingle = (Button)findViewById(R.id.buttonSingle);
        buttonVersus = (Button)findViewById(R.id.buttonVersus);
        buttonCoop = (Button)findViewById(R.id.buttonCoop);
        buttonScores = (Button)findViewById(R.id.buttonScores);
        buttonSettings = (Button)findViewById(R.id.buttonSettings);
        imageViewClock = (ImageView)findViewById(R.id.imageViewClock);

        EventHandler eventHandler = new EventHandler();
        buttonSingle.setOnClickListener(eventHandler);
        buttonVersus.setOnClickListener(eventHandler);
        buttonCoop.setOnClickListener(eventHandler);
        buttonScores.setOnClickListener(eventHandler);
        buttonSettings.setOnClickListener(eventHandler);
        imageViewClock.setOnLongClickListener(eventHandler);

        buttonSingle.setBackgroundResource(R.drawable.buttonbar);
        buttonVersus.setBackgroundResource(R.drawable.buttonbar);
        buttonCoop.setBackgroundResource(R.drawable.buttonbar);
        buttonScores.setBackgroundResource(R.drawable.buttonbar);
        buttonSettings.setBackgroundResource(R.drawable.buttonbar);

        clock();
    }

    public void clock() {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.clockwise);
        imageViewClock.startAnimation(animation);
    }

    class EventHandler implements View.OnClickListener, View.OnLongClickListener {
        @Override
        public void onClick(View view) {
            Intent intent;
            switch (view.getId()) {
                case R.id.buttonSingle:
                    intent = new Intent(Main_Activity.this, Single_Activity.class);
                    startActivity(intent);
                    break;
                case R.id.buttonVersus:
                    intent = new Intent(Main_Activity.this, Versus_Activity.class);
                    startActivity(intent);
                    break;
                case R.id.buttonCoop:
                    intent = new Intent(Main_Activity.this, Coop_Activity.class);
                    startActivity(intent);
                    break;
                case R.id.buttonScores:
                    intent = new Intent(Main_Activity.this, Scores_Activity.class);
                    startActivity(intent);
                    break;
                case R.id.buttonSettings:
                    intent = new Intent(Main_Activity.this, Settings_Activity.class);
                    startActivity(intent);
                    break;
            }
        }

        @Override
        public boolean onLongClick(View view) {
            switch (view.getId()) {
                case R.id.imageViewClock:
                    Intent intent = new Intent(Main_Activity.this, Jones_Activity.class);
                    startActivity(intent);
                    break;
            }
            return true;
        }
    }
}
