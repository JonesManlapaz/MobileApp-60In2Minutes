package com.jones.jonesmanlapazapplication;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Versus_Activity extends AppCompatActivity {

    private Button buttonStart;
    private TextView textViewInstruction1, textViewTimer1, textViewInstruction2, textViewTimer2;
    final String INSTRUCTION_MESSAGE = "In this game, you and your opponent will have their own side of the screen, need to click the buttons in ASCENDING order and see who would finish first. Caution: You each only have a minute.";
    final int MAX_BUTTON_COUNT = 30;
    int numberToClick, numberToClick2, timeRemaining, showToastLost, showWinMessage, chosenSize, numberOfButtonsLeft;
    String winner_Name = "", loser_Name = "";

    Button buttonx[] = new Button[60];

    MediaPlayer backgroundSound = new MediaPlayer();
    MediaPlayer clickSoundCorrect = new MediaPlayer();
    MediaPlayer clickSoundCorrectw = new MediaPlayer();
    MediaPlayer clickSoundCorrectx = new MediaPlayer();
    MediaPlayer clickSoundCorrecty = new MediaPlayer();
    MediaPlayer clickSoundCorrectz = new MediaPlayer();
    MediaPlayer clickSoundWrong = new MediaPlayer();
    MediaPlayer clickSoundWrongx = new MediaPlayer();
    MediaPlayer lostSound = new MediaPlayer();
    MediaPlayer winSound = new MediaPlayer();

    //get the database reference for root node
    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();

    CountDownTimer countDownTimer = new CountDownTimer(61000, 1000) {
        public void onTick(long millisUntilFinished) {
            textViewTimer1.setText("Seconds remaining: " + millisUntilFinished / 1000);
            textViewTimer2.setText("Seconds remaining: " + millisUntilFinished / 1000);
            timeRemaining = (int)(millisUntilFinished / 1000);
        }

        public void onFinish() {
            for(int i = 0; i < 60; i++){
                buttonx[i].setEnabled(false);
            }
            buttonStart.setVisibility(View.VISIBLE);
            textViewTimer1.setVisibility(View.INVISIBLE);
            textViewTimer2.setVisibility(View.INVISIBLE);
            if (showToastLost == 0) {
                lostSound.start();
                Toast.makeText(Versus_Activity.this, "Sorry, you run-out of time!", Toast.LENGTH_SHORT).show();
                showToastLost = 1;
                backgroundSound.stop();
            }
        }
    };

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_versus_);

        buttonStart = (Button)findViewById(R.id.buttonStart);
        textViewInstruction1 = (TextView)findViewById(R.id.textViewInstruction1);
        textViewInstruction2 = (TextView)findViewById(R.id.textViewInstruction2);
        textViewInstruction1.setText(INSTRUCTION_MESSAGE);
        textViewInstruction2.setText(INSTRUCTION_MESSAGE);
        textViewTimer1 = (TextView)findViewById(R.id.textViewTimer1);
        textViewTimer2 = (TextView)findViewById(R.id.textViewTimer2);

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

        for(int x = 0; x < 60; x++) {
            buttonx[x].setOnClickListener(eventHandler);
            buttonx[x].setVisibility(View.INVISIBLE);
        }
        textViewTimer1.setVisibility(View.INVISIBLE);
        textViewTimer2.setVisibility(View.INVISIBLE);
        showToastLost = 0;
        showWinMessage = 0;

        backgroundSound = MediaPlayer.create(this, R.raw.versusbackgroundmusic);
        clickSoundCorrect = MediaPlayer.create(this, R.raw.correct);
        clickSoundCorrectw = MediaPlayer.create(this, R.raw.correct);
        clickSoundCorrectx = MediaPlayer.create(this, R.raw.correct);
        clickSoundCorrecty = MediaPlayer.create(this, R.raw.correct);
        clickSoundCorrectz = MediaPlayer.create(this, R.raw.correct);
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
                    testIfCorrect2(30);
                    break;
                case R.id.button31:
                    testIfCorrect2(31);
                    break;
                case R.id.button32:
                    testIfCorrect2(32);
                    break;
                case R.id.button33:
                    testIfCorrect2(33);
                    break;
                case R.id.button34:
                    testIfCorrect2(34);
                    break;
                case R.id.button35:
                    testIfCorrect2(35);
                    break;
                case R.id.button36:
                    testIfCorrect2(36);
                    break;
                case R.id.button37:
                    testIfCorrect2(37);
                    break;
                case R.id.button38:
                    testIfCorrect2(38);
                    break;
                case R.id.button39:
                    testIfCorrect2(39);
                    break;
                case R.id.button40:
                    testIfCorrect2(40);
                    break;
                case R.id.button41:
                    testIfCorrect2(41);
                    break;
                case R.id.button42:
                    testIfCorrect2(42);
                    break;
                case R.id.button43:
                    testIfCorrect2(43);
                    break;
                case R.id.button44:
                    testIfCorrect2(44);
                    break;
                case R.id.button45:
                    testIfCorrect2(45);
                    break;
                case R.id.button46:
                    testIfCorrect2(46);
                    break;
                case R.id.button47:
                    testIfCorrect2(47);
                    break;
                case R.id.button48:
                    testIfCorrect2(48);
                    break;
                case R.id.button49:
                    testIfCorrect2(49);
                    break;
                case R.id.button50:
                    testIfCorrect2(50);
                    break;
                case R.id.button51:
                    testIfCorrect2(51);
                    break;
                case R.id.button52:
                    testIfCorrect2(52);
                    break;
                case R.id.button53:
                    testIfCorrect2(53);
                    break;
                case R.id.button54:
                    testIfCorrect2(54);
                    break;
                case R.id.button55:
                    testIfCorrect2(55);
                    break;
                case R.id.button56:
                    testIfCorrect2(56);
                    break;
                case R.id.button57:
                    testIfCorrect2(57);
                    break;
                case R.id.button58:
                    testIfCorrect2(58);
                    break;
                case R.id.button59:
                    testIfCorrect2(59);
                    break;
            }
        }
        //this is where you could put more override like onLongClick or onCheckedChanged
    }

    private void generateRandomNumbers() {
        Random randomNumber = new Random();
        for(int i = 0; i < 30; i++){
            int generatedNumber = randomNumber.nextInt(MAX_BUTTON_COUNT) + 1;
            int acceptNumber = 1;
            if (i == 0) {
                buttonx[i].setText(String.valueOf(generatedNumber));
                buttonx[i].setBackgroundResource(R.drawable.buttonfaceorange);
                buttonx[30+i].setText(String.valueOf(generatedNumber));
                buttonx[30+i].setBackgroundResource(R.drawable.buttonfaceblue);
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
                    buttonx[i].setBackgroundResource(R.drawable.buttonfaceorange);
                    buttonx[30+i].setText(String.valueOf(generatedNumber));
                    buttonx[30+i].setBackgroundResource(R.drawable.buttonfaceblue);
                }
            }
        }
        numberToClick = 1;
        numberToClick2 = 1;
        textViewInstruction1.setVisibility(View.INVISIBLE);
        textViewInstruction2.setVisibility(View.INVISIBLE);
        buttonStart.setVisibility(View.INVISIBLE);
        for(int i = 0; i < 60; i++){
            buttonx[i].setVisibility(View.VISIBLE);
            buttonx[i].setEnabled(true);
        }
        backgroundSound = MediaPlayer.create(this, R.raw.versusbackgroundmusic);
        backgroundSound.start();
        textViewTimer1.setVisibility(View.VISIBLE);
        textViewTimer2.setVisibility(View.VISIBLE);
        showWinMessage = 0;
        showToastLost = 0;
        countDownTimer.start();
    }

    private void testIfCorrect(int x){
        if (buttonx[x].getText() == String.valueOf(numberToClick)) {
            buttonx[x].setVisibility(View.INVISIBLE);
            makeCorrectSound();
            if (buttonx[x].getText() == String.valueOf(30)) {
                buttonStart.setVisibility(View.VISIBLE);
                for(int i = 30; i < 60; i++){
                    buttonx[i].setEnabled(false);
                    showHide();
                    // win - add code to save score
                    if (showWinMessage == 0) {
                        winSound.start();
                        numberOfButtonsLeft = 31 - numberToClick2;
                        acquireNameOfWinner(1, numberOfButtonsLeft);
                        showWinMessage = 1;
                    }
                }
            }
            numberToClick = numberToClick + 1;
        } else {
            makeWrongSound();
        }
    }

    private void testIfCorrect2(int x2){
        if (buttonx[x2].getText() == String.valueOf(numberToClick2)) {
            buttonx[x2].setVisibility(View.INVISIBLE);
            makeCorrectSound();
            if (buttonx[x2].getText() == String.valueOf(30)) {
                buttonStart.setVisibility(View.VISIBLE);
                for(int i2 = 0; i2 < 30; i2++){
                    buttonx[i2].setEnabled(false);
                    showHide();
                    // win - add code to save score
                    if (showWinMessage == 0) {
                        winSound.start();
                        numberOfButtonsLeft = 31 - numberToClick;
                        acquireNameOfWinner(2, numberOfButtonsLeft);
                        showWinMessage = 1;
                    }
                }
            }
            numberToClick2 = numberToClick2 + 1;
        } else {
            makeWrongSound();
        }
    }

    private void makeCorrectSound() {
        if (clickSoundCorrect.isPlaying()){
            if (clickSoundCorrectw.isPlaying()){
                if (clickSoundCorrectx.isPlaying()){
                    if (clickSoundCorrecty.isPlaying()){
                        clickSoundCorrectz.start();
                    } else {
                        clickSoundCorrecty.start();
                    }
                } else {
                    clickSoundCorrectx.start();
                }
            } else {
                clickSoundCorrectw.start();
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
        for(int i = 0; i < 60; i++){
            buttonx[i].setEnabled(false);
        }
        buttonStart.setVisibility(View.VISIBLE);
        textViewTimer1.setVisibility(View.INVISIBLE);
        textViewTimer2.setVisibility(View.INVISIBLE);
        countDownTimer.cancel();
        backgroundSound.stop();
    }

    // saving info to the database
    private void acquireNameOfWinner(int player, int numberOfButtonsLeft) {
        final int buttonsLeft = numberOfButtonsLeft;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Winner's Name");
        if (player == 1) {
            builder.setMessage("ORANGE player finished it with opponent left with " + buttonsLeft + " buttons. Please input winner's name here.");
            textViewInstruction1.setVisibility(View.VISIBLE);
        } else {
            builder.setMessage("BLUE player finished it with opponent left with " + buttonsLeft + " buttons Please input winner's name here.)");
            textViewInstruction2.setVisibility(View.VISIBLE);
        }
        // Set up the inputName
        final EditText inputName = new EditText(this);
        inputName.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(inputName);

        // Set up the dialog box and accept input
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                winner_Name = inputName.getText().toString();

                // for second player
                AlertDialog.Builder builder2 = new AlertDialog.Builder(Versus_Activity.this);
                builder2.setCancelable(false);
                builder2.setTitle("Loser's Name");
                // Set up the inputName
                final EditText inputName2 = new EditText(Versus_Activity.this);
                inputName2.setInputType(InputType.TYPE_CLASS_TEXT);
                builder2.setView(inputName2);

                Date curDate = new Date();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
                final String DateToStr = format.format(curDate);

                // Set up the dialog box and accept input
                builder2.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        loser_Name = inputName2.getText().toString();

                        //auto-generate key and return the key (studentId)
                        String keyScores = rootRef.push().getKey();

                        //next two lines creates child nodes and set values to them
                        rootRef.child(keyScores).child("Name").setValue(winner_Name + " won over " + loser_Name);
                        rootRef.child(keyScores).child("Time").setValue(buttonsLeft);
                        rootRef.child(keyScores).child("Date").setValue(DateToStr);
                        rootRef.child(keyScores).child("Mode").setValue("Versus");
                    }
                });
                builder2.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder2.show();
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