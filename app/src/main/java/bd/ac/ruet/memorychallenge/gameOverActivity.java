package bd.ac.ruet.memorychallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class gameOverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        TextView tv_score = (TextView) findViewById(R.id.textView_final_score);
        TextView tv_desc = (TextView) findViewById(R.id.textView_scoreDescription);

        String gameScore = getIntent().getExtras().getString("getPointsString");
        String description = getIntent().getExtras().getString("messageString");

        tv_score.setText("" + gameScore);
        tv_desc.setText("" + description);


    }

    public void onClick_mainMenu(View view) {
        startActivity(new Intent(gameOverActivity.this, MainMenuActivity.class));
        finish();
    }
}
