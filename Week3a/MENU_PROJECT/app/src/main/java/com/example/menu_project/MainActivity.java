package com.example.menu_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;

import static android.Manifest.permission_group.SMS;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton new_activity = findViewById(R.id.new_activity);
        new_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent new_activity = new Intent(MainActivity.this, NewActivity.class);
                startActivity(new_activity);
            }
        });
    }

    public void sendSMS(View v) {
        final Intent sms = new Intent(Intent.ACTION_SENDTO);
        sms.setData(Uri.parse("smsto:" + Uri.encode("9292152433")));
        sms.putExtra("sms_body", "Hello, This is Peiying from CS374");
        startActivity(sms);
    }

    public void call(View v) {
        final Intent call = new Intent(Intent.ACTION_DIAL);
        call.setData(Uri.parse("tel:9292152433"));
        startActivity(call);
    }

    public void web(View v) {
        final Intent web = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"));
        startActivity(web);
    }

    public void map(View v) {
        String geoUri = String.format("geo:38.899533,-77.036476");
        Uri geo = Uri.parse(geoUri);
        Intent map = new Intent(Intent.ACTION_VIEW, geo);
        startActivity(map);
    }

    public void share(View v) {
        final Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        getIntent().putExtra(Intent.EXTRA_SUBJECT, "CS374");
        share.putExtra(Intent.EXTRA_TEXT, "Join CS639");
        startActivity(Intent.createChooser(share, "Share the love"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


    public boolean help(MenuItem item) {
        Intent help = new Intent(MainActivity.this, HelpActivity.class);
        startActivity(help);
        return true;
    }

    public boolean setting(MenuItem item) {
        final Intent setting = new Intent(Settings.ACTION_SETTINGS);
        startActivity(setting);
        return true;
    }
}