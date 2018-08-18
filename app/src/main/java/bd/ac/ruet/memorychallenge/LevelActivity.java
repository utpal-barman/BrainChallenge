package bd.ac.ruet.memorychallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
    }

    public void onClick_level1(View view) {
        startActivity(new Intent(LevelActivity.this, Regular1Activity.class));
        finish();
    }

    public void onClick_level2(View view) {
        Toast.makeText(LevelActivity.this, "Level 2 is under construction!", Toast.LENGTH_SHORT).show();
    }

    public void onClick_level3(View view) {
        Toast.makeText(LevelActivity.this, "Level 3 is under construction!", Toast.LENGTH_SHORT).show();
    }
}
