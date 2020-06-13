package com.example.magic_8_ball;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class MainActivity<input> extends AppCompatActivity{

    String question;
    EditText questionInput;

    private ImageButton button;
    private TextView textview;
    private ImageView imageview;
    private TextView input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (ImageButton)findViewById(R.id.image);
        textview = (TextView)findViewById(R.id.answer);
        imageview = (ImageView)findViewById(R.id.answerImage);
        input = (TextView) findViewById(R.id.textview_input);
        textview.setVisibility(View.INVISIBLE);

        showmagic_8_ball();

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                showmagic_8_ball();
                input.setText("");
                textview.setVisibility(View.VISIBLE);
            }
        });

    }

    public void showmagic_8_ball(){
        shuffleanswers();
        imageview.setImageResource(answerArray[0].getImage());
        textview.setText(answerArray[0].getText());
    }

    answers f01 = new answers(R.drawable.t1, "As I see it, yes");
    answers f02 = new answers(R.drawable.t2, "Ask again later.");
    answers f03 = new answers(R.drawable.t3, "Better not tell you now.");
    answers f04 = new answers(R.drawable.t4, "It is certain.");
    answers f05 = new answers(R.drawable.t5, "It is decidedly so.");
    answers f06 = new answers(R.drawable.t6, "My sources say no.");
    answers f07 = new answers(R.drawable.t7, "Signs point to yes.");
    answers f08 = new answers(R.drawable.t8, "Very doubtful.");
    answers f09 = new answers(R.drawable.t9, "You may rely on it.");

    answers[]answerArray = new answers[]{
            f01,f02,f03,f04,f05,f06,f07,f08,f09
    };
    public void shuffleanswers(){
        Collections.shuffle(Arrays.asList(answerArray));
    }
}