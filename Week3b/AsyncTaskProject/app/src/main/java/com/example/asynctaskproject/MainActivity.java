package com.example.asynctaskproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText url;
    Button clear, submit;
    ImageView image;
    private Bitmap bmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url = findViewById(R.id.url);
        clear = findViewById(R.id.clear);
        submit = findViewById(R.id.submit);
        image = findViewById(R.id.image);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url.setText("");
                image.setImageBitmap(null);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = url.getText().toString();
                if(link.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please enter url",
                        Toast.LENGTH_SHORT).show();
                }else {
                    LoadImage loadImage = new LoadImage(image);
                    loadImage.execute(link);
                }
            }
        });
    }

    private  class LoadImage extends AsyncTask<String,Void,Bitmap>{
        ImageView image;
        public LoadImage(ImageView image){
            this.image =image;
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            String link = params [0];
            HttpURLConnection connection = null;
            try {
                URL url = new URL(link);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(8000);
                connection.setReadTimeout(8000);
                InputStream inputStream = connection.getInputStream();
                bmp = BitmapFactory.decodeStream(inputStream);
                inputStream.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            return bmp;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            image.setImageBitmap(bmp);
            super.onPostExecute(result);
        }
    }
}