package com.jones.jonesmanlapazapplication;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Scores_Activity extends AppCompatActivity {

    protected ListView listViewScores;
    private ArrayList<Score> scores;
    private ScoreAdapter scoreAdapter;
    RadioButton radioButtonSingle, radioButtonVersus, radioButtonCoop;
    TextView textViewBest;

    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores_);

        textViewBest = (TextView)findViewById(R.id.textViewBest);
        radioButtonSingle = (RadioButton)findViewById(R.id.radioButtonSingle);
        radioButtonVersus = (RadioButton)findViewById(R.id.radioButtonVersus);
        radioButtonCoop = (RadioButton)findViewById(R.id.radioButtonCoop);
        listViewScores = (ListView)findViewById(R.id.listViewScores);

        EventHandler eventHandler = new EventHandler();
        radioButtonSingle.setOnClickListener(eventHandler);
        radioButtonVersus.setOnClickListener(eventHandler);
        radioButtonCoop.setOnClickListener(eventHandler);

        showMode("Single");
    }

    class EventHandler implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.radioButtonSingle:
                    showMode("Single");
                    break;
                case R.id.radioButtonVersus:
                    showMode("Versus");
                    break;
                case R.id.radioButtonCoop:
                    showMode("Coop");
                    break;
            }
        }
        //this is where you could put more override like onLongClick or onCheckedChanged
    }

    private void showMode(String x) {
        final String chosenMode = x;

        if (chosenMode == "Versus"){
            textViewBest.setText("TOP SCORE");
        }else {
            textViewBest.setText("BEST TIME");
        }
        rootRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                scores = new ArrayList<Score>();

                for (DataSnapshot playerScore : dataSnapshot.getChildren()) {

                    // making sure that it does not go into error when a new set of data is being recorded to the database
                    if(playerScore.child("Mode").getValue() != null) {

                        // to get only the chosen mode on the list
                        if (playerScore.child("Mode").getValue().toString().matches(chosenMode)) {
                            scores.add(new Score(playerScore.child("Name").getValue().toString(), playerScore.child("Time").getValue().toString(), playerScore.child("Date").getValue().toString(), playerScore.child("Mode").getValue().toString()));
                        }
                    }
                }
                // to sort the listview
                Collections.sort(scores);
                scoreAdapter = new ScoreAdapter(Scores_Activity.this, R.layout.player, scores);
                listViewScores.setAdapter(scoreAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // place a code if you want it to do something
            }
        });
    }

    public class Score implements Comparable<Score> {
        private String playerName;
        private String playerTime;
        private String playedDate;
        private String playedMode;

        public Score(String playerName, String playerTime, String playedDate, String playedMode) {
            this.playerName = playerName;
            this.playerTime = playerTime;
            this.playedDate = playedDate;
            this.playedMode = playedMode;
        }

        public String getPlayerName() {
            return playerName;
        }
        public String getPlayerTime() {
            return playerTime;
        }
        public String getPlayedDate() {
            return playedDate;
        }
        public String getPlayedMode() {
            return playedMode;
        }

        @Override
        public int compareTo(@NonNull Score o)
        {
            // sorting it from highest score to lowest
            return Integer.valueOf(o.getPlayerTime()) - Integer.valueOf(this.getPlayerTime());
        }
    }

    private class ScoreAdapter extends ArrayAdapter<Score> {

        private ArrayList<Score> items;

        public ScoreAdapter(Context context, int textViewResourceId, ArrayList<Score> items) {
            super(context, textViewResourceId, items);
            this.items = items;
        }

        //This method is called once for every item in the ArrayList as the list is loaded.
        //It returns a View -- a list item in the ListView -- for each item in the ArrayList
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.player, null);
            }
            Score o = items.get(position);

            if (o != null) {
                TextView textViewName = (TextView) v.findViewById(R.id.textViewName);
                TextView textViewtime = (TextView) v.findViewById(R.id.textViewtime);
                TextView textViewDate = (TextView) v.findViewById(R.id.textViewDate);

                TextView textViewTitle = (TextView) v.findViewById(R.id.textViewTitle);
                if (textViewBest.getText() == "TOP SCORE"){
                    textViewTitle.setText("Opponent's remaining buttons: ");
                }else {
                    textViewTitle.setText("Seconds remaining: ");
                }
                // to put the ranking
                TextView ranking = (TextView) v.findViewById(R.id.textViewPosition);
                int pos = position+1;
                ranking.setText(" " + pos);
                pos++;

                if (textViewName != null) {
                    textViewName.setText(o.getPlayerName());
                }
                if (textViewtime != null) {
                    textViewtime.setText(o.getPlayerTime());
                }
                if (textViewDate != null) {
                    textViewDate.setText(o.getPlayedDate());
                }
            }
            return v;
        }
    }
}
