package com.jones.jonesmanlapazapplication;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;

public class Jones_Activity extends AppCompatActivity {

    private ImageView imageViewClock;
    private TextView textViewTesters;
    private String Testers = "Julian Vansteenbergen, Ryan Picard, Chelsy";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jones);
        imageViewClock = (ImageView)findViewById(R.id.imageViewClock);
        textViewTesters = (TextView)findViewById(R.id.textViewTesters);

        try {
            Resources res = getResources();
            InputStream in_s = res.openRawResource(R.raw.beta_testers);

            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            textViewTesters.setText(new String(b));
        } catch (Exception e) {
            // e.printStackTrace();
            textViewTesters.setText("Error: can't show list of beta testers.");
        }
        clock();
    }

    public void clock() {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.clockwise);
        //animation.setRepeatCount(Animation.INFINITE);
        // animation.setRepeatMode(Animation.INFINITE);
        imageViewClock.startAnimation(animation);
    }
}
