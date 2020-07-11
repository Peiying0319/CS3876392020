package com.example.mday;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton eat_btn = findViewById(R.id.eat_img_btn);
        ImageButton do_btn = findViewById(R.id.do_img_btn);
        ImageButton go_btn = findViewById(R.id.go_img_btn);
        ImageButton travel_btn = findViewById(R.id.travel_img_btn);
        ImageButton yes_or_no_btn = findViewById(R.id.yes_or_no_btn);

        eat_btn.setOnClickListener(this);
        do_btn.setOnClickListener(this);
        go_btn.setOnClickListener(this);
        travel_btn.setOnClickListener(this);
        yes_or_no_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.eat_img_btn:
                Intent intent = new Intent(this,EatActivity.class);
                startActivity(intent);
                break;
            case R.id.do_img_btn:
                Intent intent1 = new Intent(this,DoActivity.class);
                startActivity(intent1);
                break;
            case R.id.go_img_btn:
                Intent intent2 = new Intent(this,GoActivity.class);
                startActivity(intent2);
                break;
            case R.id.travel_img_btn:
                Intent intent3 = new Intent(this,TravelActivity.class);
                startActivity(intent3);
                break;
            case R.id.yes_or_no_btn:
                Intent intent4 = new Intent(this,YesOrNoActivity.class);
                startActivity(intent4);
                break;
        }
    }
}