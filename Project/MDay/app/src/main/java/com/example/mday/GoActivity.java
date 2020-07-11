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

public class GoActivity extends AppCompatActivity {

    private Button tap;
    private ImageView image;
    private TextView textView;
    private Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.where_to_go_layout);

        tap = (Button)findViewById(R.id.btn_go_tap);
        image = (ImageView)findViewById(R.id.img_go_places);
        textView = (TextView)findViewById(R.id.go_text);
        search = (Button)findViewById(R.id.btn_go_search);

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
    Answer f01 = new Answer(R.drawable.go_museum,"The Metropolitan Museum of Art");
    Answer f02 = new Answer(R.drawable.go_park,"Central Park");
    Answer f03 = new Answer(R.drawable.go_cafe,"Café Carlyle");
    Answer f04 = new Answer(R.drawable.go_cloisters,"The Cloisters");
    Answer f05 = new Answer(R.drawable.go_garden,"New York Botanical Garden");
    Answer f06 = new Answer(R.drawable.go_lincoln,"Lincoln Center");
    Answer f07 = new Answer(R.drawable.go_library,"the Morgan Library");
    Answer f08 = new Answer(R.drawable.go_philharmonic,"The New York Philharmonic");
    Answer f09 = new Answer(R.drawable.go_terminal,"Grand Central Terminal");
    Answer f10 = new Answer(R.drawable.go_empire,"Empire State building");

    Answer[]answersArray = new Answer[]{
            f01,f02,f03,f04,f05,f06,f07,f08,f09,f10
    };

    private void randomimage() {
        Collections.shuffle(Arrays.asList(answersArray));
    }

    public void btn_go_search(View v) {
        final Intent web = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"));
        startActivity(web);
    }
}