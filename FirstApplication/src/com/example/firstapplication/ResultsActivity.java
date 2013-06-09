package com.example.firstapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Richard on 9/06/13.
 */
public class ResultsActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.result_view);

        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
            String value = extras.getString("score");
            TextView scoreText = (TextView)findViewById(R.id.textView);
            scoreText.setText("Your score is "+value);
        }

        Button retryButton = (Button)findViewById(R.id.RetryButton);
        retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startAgain = new Intent(ResultsActivity.this, MainActivity.class);
                startActivity(startAgain);
            }
        });
    }
}