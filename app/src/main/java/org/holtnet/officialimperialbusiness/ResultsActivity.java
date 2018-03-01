package org.holtnet.officialimperialbusiness;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    private int score;
    private double percentScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_results);

        score = 0;

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            score = extras.getInt("FINAL_SCORE");
        }

        percentScore = (score / 14.0) * 100;

        TextView scoreView = findViewById(R.id.Score);
        scoreView.setText(String.valueOf((int)percentScore) + "%");

        Button returnButton = findViewById(R.id.return_button);

        /**
         * You keep creating Intents and never release them.  If you ran through your quiz multiple
         * times you would see a ton of Views / Intents stacked on top of each other and if you kept
         * going would eventually run out of memory and crash.
         *
         * Note how I tweaked your methods to release the current Intents and go back to the main
         * menu.  Also note how the visual has changed from what you had before.
         */
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent beginIntent = new Intent(ResultsActivity.this, MainActivity.class);
//                startActivity(beginIntent);
                finish();
            }
        });
    }
}
