package bd.ac.ruet.memorychallenge;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Regular1Activity extends AppCompatActivity {

    private Button btn_a, btn_b, btn_c;
    private TextView tv_input, tv_score, tv_timer;
    private int count, flag = 0;
    private int gamePoints = 0;
    CountDownTimer timer;
    private String[] stringList = {"", "আ", "কা", "শ", "গো", "ল", "ক", "নো", "ল", "ক", "ক", "বি", "তা",
                                       "গো", "ব", "র", "র", "চ", "না", "ন", "র", "ক", "হা", "তু", "ড়ি",
                                       "জা", "হা", "জ", "প", "তা", "কা", "যৌ", "তু", "ক", "দ", "য়া", "লু",
                                       "মা", "ন", "ব", "লা", "টি", "ম", "হ", "রি", "ণ", "পো", "ষ", "ক",
                                       "পো", "শা", "ক", "আ", "ন", "ন্দ", "ই", "ন্দ্রি", "য়", "লৌ", "কি", "ক",
                                       "বা", "ন", "র", "ডা", "লি", "ম", "গা", "ম", "ছা", "বি", "ড়া", "ল",
                                        "রা", "খা", "ল", "ডা", "লি", "ম"
                                  };
    private String[] correctStringArray = new String[3];
    private String btn_str1, btn_str2, btn_str3, userString, correctString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regular1);

        btn_a = (Button) findViewById(R.id.button_a);
        btn_b = (Button) findViewById(R.id.button_b);
        btn_c = (Button) findViewById(R.id.button_c);

        tv_input = (TextView) findViewById(R.id.textView_input);
        tv_score = (TextView) findViewById(R.id.textView_score);
        tv_timer = (TextView) findViewById(R.id.textView_timer);

        timer = new CountDownTimer(99000, 1000) {

            public void onTick(long millisUntilFinished) {
                tv_timer.setText("" + millisUntilFinished / 1000);
                if ((Integer.parseInt(tv_timer.getText().toString())) < 10) {
                    tv_timer.setTextColor(Color.RED);
                }
            }
            public void onFinish() {
                Intent intent = new Intent(Regular1Activity.this, gameOverActivity.class);
                intent.putExtra("getPointsString", ""+gamePoints);
                intent.putExtra("messageString", "দুঃখিত। নির্ধারিত সময় শেষ!");
                startActivity(intent);
                finish();
            }
        };

        timer.start();

        startNewGame();

    }

    private void startNewGame(){
        tv_input.setText("");
        userString = "";
        count = 0;

        int randomStringPosition = (int) (1 + (Math.random() * 123) % (stringList.length - 1));


        if(randomStringPosition % 3 == 1){
            btn_str1 = stringList[randomStringPosition];
            btn_str2 = stringList[randomStringPosition + 2];
            btn_str3 = stringList[randomStringPosition + 1];

            correctStringArray[0] = btn_str1;
            correctStringArray[1] = btn_str3;
            correctStringArray[2] = btn_str2;

            correctString = stringMaker(correctStringArray);
        }

        else if(randomStringPosition % 3 == 0){
            btn_str1 = stringList[randomStringPosition - 1];
            btn_str2 = stringList[randomStringPosition - 2];
            btn_str3 = stringList[randomStringPosition];

            correctStringArray[0] = btn_str2;
            correctStringArray[1] = btn_str1;
            correctStringArray[2] = btn_str3;

            correctString = stringMaker(correctStringArray);
        }

        else if(randomStringPosition % 3 == 2){
            btn_str1 = stringList[randomStringPosition + 1];
            btn_str2 = stringList[randomStringPosition - 1];
            btn_str3 = stringList[randomStringPosition];

            correctStringArray[0] = btn_str2;
            correctStringArray[1] = btn_str3;
            correctStringArray[2] = btn_str1;

            correctString = stringMaker(correctStringArray);
        }

        else {
            Toast.makeText(Regular1Activity.this, "Error occurred!", Toast.LENGTH_SHORT).show();
        }

        btn_a.setText(btn_str1);
        btn_b.setText(btn_str2);
        btn_c.setText(btn_str3);
    }

    public void onClick_a(View view) {
        tv_input.setText(userString + btn_a.getText());
        userString = tv_input.getText().toString();

        count++;
        if(count==3){
            if(tv_input.getText().toString().equals(correctString)){
                Toast.makeText(Regular1Activity.this, "Correct!", Toast.LENGTH_SHORT).show();
                updateGamePoints();
                tv_score.setText(""+gamePoints);

            }
            else {
                Toast.makeText(Regular1Activity.this, "Wrong!! Correct Answer is: " + correctString, Toast.LENGTH_SHORT).show();
                negativeGamePoints();
            }

            startNewGame();
        }
    }

    public void onClick_b(View view) {
        tv_input.setText(userString + btn_b.getText());
        userString = tv_input.getText().toString();

        count++;
        if (count == 3) {
            if (tv_input.getText().toString().equals(correctString)) {
                Toast.makeText(Regular1Activity.this, "Correct!", Toast.LENGTH_SHORT).show();
                updateGamePoints();
                tv_score.setText(""+gamePoints);
            }
            else {
                Toast.makeText(Regular1Activity.this, "Wrong!! Correct Answer is: " + correctString, Toast.LENGTH_SHORT).show();
                negativeGamePoints();
            }

            startNewGame();
        }
    }

    public void onClick_c(View view) {
        tv_input.setText(userString + btn_c.getText());
        userString = tv_input.getText().toString();

        count++;
        if (count == 3) {
            if (tv_input.getText().toString().equals(correctString)) {
                Toast.makeText(Regular1Activity.this, "Correct!", Toast.LENGTH_SHORT).show();
                updateGamePoints();
                tv_score.setText(""+gamePoints);
            }
            else {
                Toast.makeText(Regular1Activity.this, "Wrong!! Correct Answer is: " +correctString, Toast.LENGTH_SHORT).show();
                negativeGamePoints();
            }

            startNewGame();
        }
    }

    private void updateGamePoints(){
        gamePoints = gamePoints + 5;
        int FIXED_POINTS = 100;
        if(gamePoints >= FIXED_POINTS && flag == 0){
            Snackbar.make(findViewById(R.id.gameLayout), "অভিনন্দন! আপনি নির্ধারিত সময়ের আগেই স্কোর করে ফেলেছেন।", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Skip Game", new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            timer.cancel();
                            Intent intent = new Intent(Regular1Activity.this, gameOverActivity.class);
                            intent.putExtra("getPointsString", "" + gamePoints);
                            intent.putExtra("messageString", "লেভেল ১ সফলভাবে শেষ। লেভেল ২ এর জন্য তৈরি? ");
                            startActivity(intent);
                            finish();
                        }
                    }).show();
            flag = 1;
        }
    }

    private void negativeGamePoints(){
        gamePoints = gamePoints - 10;
    }

    private String stringMaker(String[] inputStringArray){
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < inputStringArray.length; i++) {
            strBuilder.append(inputStringArray[i]);
        }
        String newString = strBuilder.toString();
        return newString;
    }


    public void onClick_exit(View view) {
        startActivity(new Intent(Regular1Activity.this, MainMenuActivity.class));
        finish();
    }

    public void onClick_help(View view) {
        overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.slide_in_left);
        startActivity(new Intent(Regular1Activity.this, HelpActivity.class));

    }

    public void onClick_mainMenu(View view) {
        startActivity(new Intent(Regular1Activity.this, MainMenuActivity.class));
        finish();
    }
}
