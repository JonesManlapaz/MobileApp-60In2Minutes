package com.jones.jonesmanlapazapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Single_Activity extends AppCompatActivity {

    private Button buttonStart;
    private TextView textViewInstruction, textViewTimer;
    final String INSTRUCTION_MESSAGE = "The goal of the game is to click the buttons in ASCENDING order before the time runs out. Caution: You are only allowed 10 mistakes.";
    final int MAX_BUTTON_COUNT = 60;
    int numberToClick, failedAttempt, timeRemaining, showToastLost, showWinMessage, chosenSize;
    String player_Name = "";

    Button buttonx[] = new Button[60];

    MediaPlayer backgroundSound = new MediaPlayer();
    MediaPlayer clickSoundCorrect = new MediaPlayer();
    MediaPlayer clickSoundCorrectx = new MediaPlayer();
    MediaPlayer clickSoundCorrecty = new MediaPlayer();
    MediaPlayer clickSoundWrong = new MediaPlayer();
    MediaPlayer clickSoundWrongx = new MediaPlayer();
    MediaPlayer lostSound = new MediaPlayer();
    MediaPlayer winSound = new MediaPlayer();

    //get the database reference for root node
    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();

    CountDownTimer countDownTimer = new CountDownTimer(121000, 1000) {

        public void onTick(long millisUntilFinished) {
            textViewTimer.setText("Seconds remaining: " + millisUntilFinished / 1000);
            timeRemaining = (int)(millisUntilFinished / 1000);
        }

        public void onFinish() {
            for(int i = 0; i < 60; i++){
                buttonx[i].setEnabled(false);
            }
            buttonStart.setVisibility(View.VISIBLE);
            textViewTimer.setVisibility(View.INVISIBLE);
            if (showToastLost == 0) {
                lostSound.start();
                Toast.makeText(Single_Activity.this, "Sorry, you run-out of time!", Toast.LENGTH_SHORT).show();
                backgroundSound.stop();
                showToastLost = 1;
            }
        }
    };

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_);

        buttonStart = (Button)findViewById(R.id.buttonStart);
        textViewInstruction = (TextView)findViewById(R.id.textViewInstruction);
        textViewInstruction.setText(INSTRUCTION_MESSAGE);
        textViewTimer = (TextView)findViewById(R.id.textViewTimer);

        sharedPreferences = this.getSharedPreferences("generalPrefs", MODE_PRIVATE);

        EventHandler eventHandler = new EventHandler();
        buttonStart.setOnClickListener(eventHandler);

        buttonx[0] = (Button)findViewById(R.id.button0);
        buttonx[1] = (Button)findViewById(R.id.button1);
        buttonx[2] = (Button)findViewById(R.id.button2);
        buttonx[3] = (Button)findViewById(R.id.button3);
        buttonx[4] = (Button)findViewById(R.id.button4);
        buttonx[5] = (Button)findViewById(R.id.button5);
        buttonx[6] = (Button)findViewById(R.id.button6);
        buttonx[7] = (Button)findViewById(R.id.button7);
        buttonx[8] = (Button)findViewById(R.id.button8);
        buttonx[9] = (Button)findViewById(R.id.button9);

        buttonx[10] = (Button)findViewById(R.id.button10);
        buttonx[11] = (Button)findViewById(R.id.button11);
        buttonx[12] = (Button)findViewById(R.id.button12);
        buttonx[13] = (Button)findViewById(R.id.button13);
        buttonx[14] = (Button)findViewById(R.id.button14);
        buttonx[15] = (Button)findViewById(R.id.button15);
        buttonx[16] = (Button)findViewById(R.id.button16);
        buttonx[17] = (Button)findViewById(R.id.button17);
        buttonx[18] = (Button)findViewById(R.id.button18);
        buttonx[19] = (Button)findViewById(R.id.button19);

        buttonx[20] = (Button)findViewById(R.id.button20);
        buttonx[21] = (Button)findViewById(R.id.button21);
        buttonx[22] = (Button)findViewById(R.id.button22);
        buttonx[23] = (Button)findViewById(R.id.button23);
        buttonx[24] = (Button)findViewById(R.id.button24);
        buttonx[25] = (Button)findViewById(R.id.button25);
        buttonx[26] = (Button)findViewById(R.id.button26);
        buttonx[27] = (Button)findViewById(R.id.button27);
        buttonx[28] = (Button)findViewById(R.id.button28);
        buttonx[29] = (Button)findViewById(R.id.button29);

        buttonx[30] = (Button)findViewById(R.id.button30);
        buttonx[31] = (Button)findViewById(R.id.button31);
        buttonx[32] = (Button)findViewById(R.id.button32);
        buttonx[33] = (Button)findViewById(R.id.button33);
        buttonx[34] = (Button)findViewById(R.id.button34);
        buttonx[35] = (Button)findViewById(R.id.button35);
        buttonx[36] = (Button)findViewById(R.id.button36);
        buttonx[37] = (Button)findViewById(R.id.button37);
        buttonx[38] = (Button)findViewById(R.id.button38);
        buttonx[39] = (Button)findViewById(R.id.button39);

        buttonx[40] = (Button)findViewById(R.id.button40);
        buttonx[41] = (Button)findViewById(R.id.button41);
        buttonx[42] = (Button)findViewById(R.id.button42);
        buttonx[43] = (Button)findViewById(R.id.button43);
        buttonx[44] = (Button)findViewById(R.id.button44);
        buttonx[45] = (Button)findViewById(R.id.button45);
        buttonx[46] = (Button)findViewById(R.id.button46);
        buttonx[47] = (Button)findViewById(R.id.button47);
        buttonx[48] = (Button)findViewById(R.id.button48);
        buttonx[49] = (Button)findViewById(R.id.button49);

        buttonx[50] = (Button)findViewById(R.id.button50);
        buttonx[51] = (Button)findViewById(R.id.button51);
        buttonx[52] = (Button)findViewById(R.id.button52);
        buttonx[53] = (Button)findViewById(R.id.button53);
        buttonx[54] = (Button)findViewById(R.id.button54);
        buttonx[55] = (Button)findViewById(R.id.button55);
        buttonx[56] = (Button)findViewById(R.id.button56);
        buttonx[57] = (Button)findViewById(R.id.button57);
        buttonx[58] = (Button)findViewById(R.id.button58);
        buttonx[59] = (Button)findViewById(R.id.button59);

        for(int x = 0; x < MAX_BUTTON_COUNT; x++) {
            buttonx[x].setOnClickListener(eventHandler);
            buttonx[x].setVisibility(View.INVISIBLE);
        }
        textViewTimer.setVisibility(View.INVISIBLE);
        showToastLost = 0;
        showWinMessage = 0;

        backgroundSound = MediaPlayer.create(this, R.raw.singlebackgroundmusic);
        clickSoundCorrect = MediaPlayer.create(this, R.raw.correct);
        clickSoundCorrectx = MediaPlayer.create(this, R.raw.correct);
        clickSoundCorrecty = MediaPlayer.create(this, R.raw.correct);
        clickSoundWrong = MediaPlayer.create(this, R.raw.wrong);
        clickSoundWrongx = MediaPlayer.create(this, R.raw.wrong);
        lostSound = MediaPlayer.create(this, R.raw.lost);
        winSound = MediaPlayer.create(this, R.raw.win);

        buttonStart.setBackgroundResource(R.drawable.buttonbar);
    }

    @Override
    protected void onResume() {
        super.onResume();
        chosenSize = sharedPreferences.getInt("sizeChosen", 150);
        for(int i = 0; i < 60; i++){
            buttonx[i].getLayoutParams().height=(chosenSize);
            buttonx[i].setBackgroundResource(R.drawable.buttonfacecoin);
        }
        showHide();
    }

    class EventHandler implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.buttonStart:
                    generateRandomNumbers();
                    break;
                case R.id.button0:
                    testIfCorrect(0);
                    break;
                case R.id.button1:
                    testIfCorrect(1);
                    break;
                case R.id.button2:
                    testIfCorrect(2);
                    break;
                case R.id.button3:
                    testIfCorrect(3);
                    break;
                case R.id.button4:
                    testIfCorrect(4);
                    break;
                case R.id.button5:
                    testIfCorrect(5);
                    break;
                case R.id.button6:
                    testIfCorrect(6);
                    break;
                case R.id.button7:
                    testIfCorrect(7);
                    break;
                case R.id.button8:
                    testIfCorrect(8);
                    break;
                case R.id.button9:
                    testIfCorrect(9);
                    break;
                case R.id.button10:
                    testIfCorrect(10);
                    break;
                case R.id.button11:
                    testIfCorrect(11);
                    break;
                case R.id.button12:
                    testIfCorrect(12);
                    break;
                case R.id.button13:
                    testIfCorrect(13);
                    break;
                case R.id.button14:
                    testIfCorrect(14);
                    break;
                case R.id.button15:
                    testIfCorrect(15);
                    break;
                case R.id.button16:
                    testIfCorrect(16);
                    break;
                case R.id.button17:
                    testIfCorrect(17);
                    break;
                case R.id.button18:
                    testIfCorrect(18);
                    break;
                case R.id.button19:
                    testIfCorrect(19);
                    break;
                case R.id.button20:
                    testIfCorrect(20);
                    break;
                case R.id.button21:
                    testIfCorrect(21);
                    break;
                case R.id.button22:
                    testIfCorrect(22);
                    break;
                case R.id.button23:
                    testIfCorrect(23);
                    break;
                case R.id.button24:
                    testIfCorrect(24);
                    break;
                case R.id.button25:
                    testIfCorrect(25);
                    break;
                case R.id.button26:
                    testIfCorrect(26);
                    break;
                case R.id.button27:
                    testIfCorrect(27);
                    break;
                case R.id.button28:
                    testIfCorrect(28);
                    break;
                case R.id.button29:
                    testIfCorrect(29);
                    break;
                case R.id.button30:
                    testIfCorrect(30);
                    break;
                case R.id.button31:
                    testIfCorrect(31);
                    break;
                case R.id.button32:
                    testIfCorrect(32);
                    break;
                case R.id.button33:
                    testIfCorrect(33);
                    break;
                case R.id.button34:
                    testIfCorrect(34);
                    break;
                case R.id.button35:
                    testIfCorrect(35);
                    break;
                case R.id.button36:
                    testIfCorrect(36);
                    break;
                case R.id.button37:
                    testIfCorrect(37);
                    break;
                case R.id.button38:
                    testIfCorrect(38);
                    break;
                case R.id.button39:
                    testIfCorrect(39);
                    break;
                case R.id.button40:
                    testIfCorrect(40);
                    break;
                case R.id.button41:
                    testIfCorrect(41);
                    break;
                case R.id.button42:
                    testIfCorrect(42);
                    break;
                case R.id.button43:
                    testIfCorrect(43);
                    break;
                case R.id.button44:
                    testIfCorrect(44);
                    break;
                case R.id.button45:
                    testIfCorrect(45);
                    break;
                case R.id.button46:
                    testIfCorrect(46);
                    break;
                case R.id.button47:
                    testIfCorrect(47);
                    break;
                case R.id.button48:
                    testIfCorrect(48);
                    break;
                case R.id.button49:
                    testIfCorrect(49);
                    break;
                case R.id.button50:
                    testIfCorrect(50);
                    break;
                case R.id.button51:
                    testIfCorrect(51);
                    break;
                case R.id.button52:
                    testIfCorrect(52);
                    break;
                case R.id.button53:
                    testIfCorrect(53);
                    break;
                case R.id.button54:
                    testIfCorrect(54);
                    break;
                case R.id.button55:
                    testIfCorrect(55);
                    break;
                case R.id.button56:
                    testIfCorrect(56);
                    break;
                case R.id.button57:
                    testIfCorrect(57);
                    break;
                case R.id.button58:
                    testIfCorrect(58);
                    break;
                case R.id.button59:
                    testIfCorrect(59);
                    break;
            }
        }
        //this is where you could put more override like onLongClick or onCheckedChanged
    }

    private void generateRandomNumbers() {
        Random randomNumber = new Random();
        for(int i = 0; i < 60; i++){
            int generatedNumber = randomNumber.nextInt(MAX_BUTTON_COUNT) + 1;
            int acceptNumber = 1;
            if (i == 0) {
                buttonx[i].setText(String.valueOf(generatedNumber));

            } else {
                for(int j = 0; j < i; j++) {
                    if (buttonx[j].getText() == String.valueOf(generatedNumber)) {
                        acceptNumber = 0;
                    }
                }
                if (acceptNumber == 0){
                    i--;
                } else {
                    buttonx[i].setText(String.valueOf(generatedNumber));
                }
            }
        }
        backgroundSound = MediaPlayer.create(this, R.raw.singlebackgroundmusic);
        backgroundSound.start();
        numberToClick = 1;
        failedAttempt = 0;
        textViewInstruction.setVisibility(View.INVISIBLE);
        buttonStart.setVisibility(View.INVISIBLE);
        for(int i = 0; i < 60; i++){
            buttonx[i].setVisibility(View.VISIBLE);
            buttonx[i].setEnabled(true);
        }
        textViewTimer.setVisibility(View.VISIBLE);
        showWinMessage = 0;
        showToastLost = 0;
        countDownTimer.start();
    }

    private void testIfCorrect(int x){
        if (buttonx[x].getText() == String.valueOf(numberToClick)) {
            makeCorrectSound();
            buttonx[x].setVisibility(View.INVISIBLE);
            if (buttonx[x].getText() == String.valueOf(60)) {
                buttonStart.setVisibility(View.VISIBLE);
                if (showWinMessage == 0) {
                    winSound.start();
                    acquireNameOfWinner();
                    countDownTimer.cancel();
                    backgroundSound.stop();
                    textViewInstruction.setVisibility(View.VISIBLE);
                    showWinMessage = 1;
                }
            }
            numberToClick = numberToClick + 1;
        } else {
            makeWrongSound();
            if (failedAttempt >= 10) {
                for(int i = 0; i < 60; i++){
                    buttonx[i].setEnabled(false);
                }
                if (showToastLost == 0) {
                    lostSound.start();
                    Toast.makeText(Single_Activity.this, "FAILED! more than 10 failed attempts.", Toast.LENGTH_SHORT).show();
                    countDownTimer.cancel();
                    if(backgroundSound.isPlaying()){
                        backgroundSound.stop();
                    }
                    showToastLost = 1;
                }
                buttonStart.setVisibility(View.VISIBLE);
            } else {
                failedAttempt++;
            }
        }
    }

    private void makeCorrectSound() {
        if (clickSoundCorrect.isPlaying()){
            if (clickSoundCorrectx.isPlaying()){
                clickSoundCorrecty.start();
            } else {
                clickSoundCorrectx.start();
            }
        } else {
            clickSoundCorrect.start();
        }
    }

    private void makeWrongSound() {
        if (clickSoundWrong.isPlaying()){
            clickSoundWrongx.start();
        } else {
            clickSoundWrong.start();
        }
    }

    private void showHide() {
        for(int i = 0; i < 60; i++){
            buttonx[i].setEnabled(false);
        }
        buttonStart.setVisibility(View.VISIBLE);
        textViewTimer.setVisibility(View.INVISIBLE);
        countDownTimer.cancel();
        backgroundSound.stop();
    }

    // saving info to the database
    private void acquireNameOfWinner() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Winner's Name");
        builder.setMessage("You finish it with " + timeRemaining + " seconds to spare.");

        // Set up the inputName
        final EditText inputName = new EditText(this);
        inputName.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(inputName);

        //get current Date
        Date curDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
        final String DateToStr = format.format(curDate);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                player_Name = inputName.getText().toString();

                // get information to add in the database
                //auto-generate key and return the key (studentId)
                String keyScores = rootRef.push().getKey();

                //next two lines creates child nodes and set values to them
                rootRef.child(keyScores).child("Name").setValue(player_Name);
                rootRef.child(keyScores).child("Time").setValue(timeRemaining);
                rootRef.child(keyScores).child("Date").setValue(DateToStr);
                rootRef.child(keyScores).child("Mode").setValue("Single");
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        countDownTimer.cancel();
        backgroundSound.stop();
    }
}
