package com.jones.jonesmanlapazapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

public class Settings_Activity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private RadioButton radioButtonLarge, radioButtonMedium, radioButtonSmall, radioButtonCustom;
    private EditText editTextCustom;
    private ImageView imageViewClock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_);

        sharedPreferences = this.getSharedPreferences("generalPrefs", MODE_PRIVATE);

        //get the data (extras) in the intent that was used
        //to start this activity
        //Intent intent = getIntent();
        //chosenSize = intent.getIntExtra("sizeChosen", 150);
        //and do what we like with them...

        radioButtonLarge = (RadioButton)findViewById(R.id.radioButtonLarge);
        radioButtonMedium = (RadioButton)findViewById(R.id.radioButtonMedium);
        radioButtonSmall = (RadioButton)findViewById(R.id.radioButtonSmall);
        radioButtonCustom = (RadioButton)findViewById(R.id.radioButtonCustom);
        editTextCustom = (EditText)findViewById(R.id.editTextCustom);
        imageViewClock = (ImageView)findViewById(R.id.imageViewClock);

        clock();
    }

    public void clock() {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.clockwise);
        imageViewClock.startAnimation(animation);
    }

    @Override
    protected void onResume() {
        super.onResume();
        int chosenSize = sharedPreferences.getInt("sizeChosen", 150);
        if (chosenSize == 200) {
            radioButtonLarge.setChecked(true);
        }else if (chosenSize == 170) {
            radioButtonMedium.setChecked(true);
        }else if (chosenSize == 150) {
            radioButtonSmall.setChecked(true);
        }else {
            radioButtonCustom.setChecked(true);
            editTextCustom.setText(String.valueOf(chosenSize));
        }
    }

    @Override
    public void onBackPressed() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (radioButtonLarge.isChecked()) {
            editor.putInt("sizeChosen", 200);
        }else if (radioButtonMedium.isChecked()) {
            editor.putInt("sizeChosen", 170);
        }else if (radioButtonSmall.isChecked()) {
            editor.putInt("sizeChosen", 150);
        }else {
            editor.putInt("sizeChosen", Integer.parseInt(editTextCustom.getText().toString()));
        }

        //writes to an XML file in data/data/{pkg name}
        if (editor.commit()) {
            //display success Toast
        } else {
            //not successful
        }

        super.onBackPressed(); //the super call calls finish()
        //or finish();
    }
}
