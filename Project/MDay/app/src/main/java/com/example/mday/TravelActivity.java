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

public class TravelActivity extends AppCompatActivity {
    private Button tap;
    private ImageView image;
    private TextView textView;
    private Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.where_to_travel_layout);

        tap = (Button)findViewById(R.id.btn_travel_tap);
        image = (ImageView)findViewById(R.id.img_travel_places);
        textView = (TextView)findViewById(R.id.travel_text);
        search = (Button)findViewById(R.id.btn_travel_search);

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
    Answer f01 = new Answer(R.drawable.travel_new_zealand,"South Island, New Zealand");
    Answer f02 = new Answer(R.drawable.trvel_paris,"Paris");
    Answer f03 = new Answer(R.drawable.travel_bora,"Bora Bora");
    Answer f04 = new Answer(R.drawable.travel_london,"London");
    Answer f05 = new Answer(R.drawable.travel_maui,"Maui");
    Answer f06 = new Answer(R.drawable.travel_tahiti,"Tahiti");
    Answer f07 = new Answer(R.drawable.travel_tokyo,"Tokyo");
    Answer f08 = new Answer(R.drawable.travel_rome,"Rome");
    Answer f09 = new Answer(R.drawable.travel_phuket,"Phuket");
    Answer f10 = new Answer(R.drawable.travel_barcelona,"Barcelona");

    Answer[]answersArray = new Answer[]{
            f01,f02,f03,f04,f05,f06,f07,f08,f09,f10
    };

    private void randomimage() {
        Collections.shuffle(Arrays.asList(answersArray));
    }

    public void btn_travel_search(View v) {
        final Intent web = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"));
        startActivity(web);
    }
}