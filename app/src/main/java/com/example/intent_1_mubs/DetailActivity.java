package com.example.intent_1_mubs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    ImageView imgStartup;
    // Milik Startup

    //Milik services

    // Milik umum
    TextView tvPhone, tvEmail, tvWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_detail );
        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        imgStartup = findViewById( R.id.img_detail );
        tvPhone = findViewById( R.id.tv_phone );
        tvEmail = findViewById( R.id.tv_email );
        tvWebsite = findViewById( R.id.tv_website );

        final int position = getIntent().getIntExtra( "position", 1 );

        tvEmail.setText( getIntent().getStringExtra( "services" ) );
        tvPhone.setText( String.valueOf( getIntent().getIntExtra( "phone", 0 ) ) );

        tvWebsite.setText( getIntent().getStringExtra( "web" ) );

        imgStartup.setImageResource( getIntent().getIntExtra( "image", 0 ) );
        setTitle( getIntent().getStringExtra( "name" ) );

        tvEmail.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( Intent.ACTION_SENDTO, Uri.fromParts( "mailto", getIntent().getStringExtra( "services" ), null ) ) );
            }
        } );

        tvWebsite.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( Intent.ACTION_VIEW, Uri.parse( getIntent().getStringExtra( "web" ) ) ) );
            }
        } );

        tvPhone.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( Intent.ACTION_DIAL,Uri.parse( "tel:" + getIntent().getStringExtra( "phone" ) ) ) );
            }
        } );

        FloatingActionButton fab = (FloatingActionButton) findViewById( R.id.fab );
        fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make( view, "Replace with your own action", Snackbar.LENGTH_LONG )
                        .setAction( "Action", null ).show();
            }
        } );
    }
}
