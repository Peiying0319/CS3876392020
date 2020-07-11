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

public class EatActivity extends AppCompatActivity {

    private Button tap;
    private ImageView image;
    private TextView textView;
    private Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.what_to_eat_layout);

        tap = (Button)findViewById(R.id.btn_eat_tap);
        image = (ImageView)findViewById(R.id.img_eat_food);
        textView = (TextView)findViewById(R.id.eat_text);
        search = (Button)findViewById(R.id.btn_eat_search);

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
    Answer f01 = new Answer(R.drawable.eat_alfredo,"Alfredo");
    Answer f02 = new Answer(R.drawable.eat_bibimbap,"Bibimbap");
    Answer f03 = new Answer(R.drawable.eat_chiken_tikka_masala,"Chicken Tikka Masala");
    Answer f04 = new Answer(R.drawable.eat_chipotle,"Chipotle");
    Answer f05 = new Answer(R.drawable.eat_conjunto_tonkatsu,"Conjunto Tonkatsu");
    Answer f06 = new Answer(R.drawable.eat_dimsum,"Dim Sum");
    Answer f07 = new Answer(R.drawable.eat_hamburger,"Hamburger");
    Answer f08 = new Answer(R.drawable.eat_hotpot,"Hotpot");
    Answer f09 = new Answer(R.drawable.eat_korean_bbq,"Korean BBQ");
    Answer f10 = new Answer(R.drawable.eat_lasagna,"Lasagna");
    Answer f11 = new Answer(R.drawable.eat_paella,"Paella");
    Answer f12 = new Answer(R.drawable.eat_pasta,"Pasta");
    Answer f13 = new Answer(R.drawable.eat_peking_duck,"Peking Duck");
    Answer f14 = new Answer(R.drawable.eat_ramen,"Ramen");
    Answer f15 = new Answer(R.drawable.eat_salad,"Salad");
    Answer f16 = new Answer(R.drawable.eat_steak,"Steak");
    Answer f17 = new Answer(R.drawable.eat_sushi,"Sushi");
    Answer f18 = new Answer(R.drawable.eat_taco,"Taco");
    Answer f19 = new Answer(R.drawable.eat_tandoori_chicken,"Tandoori Chicken");
    Answer f20 = new Answer(R.drawable.eat_thai_food,"Thai Food");

    Answer[]answersArray = new Answer[]{
            f01,f02,f03,f04,f05,f06,f07,f08,f09,f10,f11,f12,f13,f14,f15,f16,f17,f18,f19,f20
    };

    private void randomimage() {
        Collections.shuffle(Arrays.asList(answersArray));
    }

    public void btn_eat_search(View v) {
        final Intent web = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=restaurants+near+me&ibp=gwp%3B0,6&hl=en&sa=X&ved=0ahUKEwikzozIy8TqAhWCYTUKHWkICBIQmYACCBo&biw=412&bih=604&dpr=2.63"));
        startActivity(web);
    }
}