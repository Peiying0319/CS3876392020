package com.example.mday;

import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collections;

public class YesOrNoActivity extends AppCompatActivity {

    private Button tap;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yes_or_no_layout);

        tap = (Button)findViewById(R.id.btn_yes_or_no_tap);
        textView = (TextView)findViewById(R.id.yes_or_no_text);

        showimage();

        tap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showimage();
            }
        });
    }

    public void showimage(){
        randomimage();
        textView.setText(answersArray[0].getTextView());
    }
    Answer f01 = new Answer(R.color.colorAccent,"yes");
    Answer f02 = new Answer(R.color.colorAccent,"no");

    Answer[]answersArray = new Answer[]{
            f01,f02
    };

    private void randomimage() {
        Collections.shuffle(Arrays.asList(answersArray));
    }
}