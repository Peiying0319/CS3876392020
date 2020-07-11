package com.example.mday;

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

public class DoActivity extends AppCompatActivity {

    private Button tap;
    private ImageView image;
    private TextView textView;
    private Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.what_to_do_layout);

        tap = (Button)findViewById(R.id.btn_do_tap);
        image = (ImageView)findViewById(R.id.img_do_things);
        textView = (TextView)findViewById(R.id.do_text);
        search = (Button)findViewById(R.id.btn_do_search);

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
        image.setImageResource(answersArray[0].getImage());
        textView.setText(answersArray[0].getTextView());
    }
    Answer f01 = new Answer(R.drawable.do_walk,"Go on a walk");
    Answer f02 = new Answer(R.drawable.do_gym,"Speaking of the gym, go!");
    Answer f03 = new Answer(R.drawable.do_yoga,"Practice yoga");
    Answer f04 = new Answer(R.drawable.do_call,"Call an old friend");
    Answer f05 = new Answer(R.drawable.do_painting,"Try your hand at painting");
    Answer f06 = new Answer(R.drawable.do_volunteer,"Research places to volunteer");
    Answer f07 = new Answer(R.drawable.do_poem,"Write a poem");
    Answer f08 = new Answer(R.drawable.do_party,"Plan a party");
    Answer f09 = new Answer(R.drawable.do_bake,"Bake");
    Answer f10 = new Answer(R.drawable.do_skydiving,"Try indoor skydiving!");

    Answer[]answersArray = new Answer[]{
            f01,f02,f03,f04,f05,f06,f07,f08,f09,f10
    };

    private void randomimage() {
        Collections.shuffle(Arrays.asList(answersArray));
    }

    public void btn_do_search(View v) {
        final Intent web = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"));
        startActivity(web);
    }
}