package com.example.briantrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

     Button goButton;
     Button button0;
     Button button1;
     Button button2;
     Button button3;
     TextView timerText;
     TextView scoreText;
     TextView multiText;
     TextView resultText;
     Button Play;
    ConstraintLayout constraintLayout;




    ArrayList<Integer> answers = new ArrayList<Integer>();
    int correctanswer;

    int score = 0;
    int numberOfQuestion = 0;


    public void Playagain (View view){
        score = 0;
        numberOfQuestion =0;
        timerText.setText("30s");
        scoreText.setText(Integer.toString(score)+ "/" + Integer.toString(numberOfQuestion));
        newquestion();
        Play.setVisibility(View.INVISIBLE);
        button0.setEnabled(true);
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        resultText.setText("");
        new CountDownTimer(30000,1000){

            @Override
            public void onTick(long l) {
                timerText.setText(String.valueOf(l/1000+"s"));

            }

            @Override
            public void onFinish() {
                resultText.setText("Done!");
                Play.setVisibility(View.VISIBLE);
                button0.setEnabled(false);
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);

            }
        }.start();
    }


    public void goButton (View view ){
        goButton.setVisibility(View.INVISIBLE);

        Playagain(findViewById(R.id.timerText));
        constraintLayout.setVisibility(View.VISIBLE);


    }


    public void chooseAnswer(View view){
        if (Integer.toString(correctanswer).equals(view.getTag().toString())){
            resultText.setText("correct");
            score++;

        }else{resultText.setText("wrong");
        }
        numberOfQuestion++ ;
        scoreText.setText(Integer.toString(score)+ "/" + Integer.toString(numberOfQuestion));
        newquestion();
    }


    //set the question random number
    public void newquestion (){
        //set questions
        Random random = new Random();
        int a = random.nextInt(50);
        int b = random.nextInt(50);
        multiText.setText(Integer.toString(a) + "*" +Integer.toString(b));


        correctanswer = random.nextInt(4);
        answers.clear();


        //give 4 answers
        for(int i =0 ;i<4;i++ ){
            if (i == correctanswer){
                answers.add(a*b);
            }else{
                int wronganswer = random.nextInt(61)+20;// for give answer wrong
                while (wronganswer == a*b){   //checking
                    wronganswer = random.nextInt(61)+20; // get new

                }
                answers.add(wronganswer);
            }
        }

        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goButton = findViewById(R.id.Gobutton);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        timerText = findViewById(R.id.timerText);
        scoreText = findViewById(R.id.scoreText);
        multiText = findViewById(R.id.multText);
        resultText = findViewById(R.id.resultText);
        Play = findViewById(R.id.button);
        constraintLayout= findViewById(R.id.ConstraintLayout);

goButton.setVisibility(View.VISIBLE);
        constraintLayout.setVisibility(View.INVISIBLE);
        newquestion();


    }
}
