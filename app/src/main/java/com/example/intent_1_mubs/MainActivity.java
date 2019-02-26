package com.example.intent_1_mubs;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import org.angmarch.views.NiceSpinner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
NiceSpinner niceSpinner;
FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        niceSpinner = findViewById( R.id.sp_fragment );
        List<String>array = new LinkedList<>( Arrays.asList( "First Fragment","Second Fragment","Third Fragment" ) );
        niceSpinner.attachDataSource( array );
        niceSpinner.setOnItemSelectedListener( this );
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace( R.id.container,new FirstFragment() ).addToBackStack( "any" ).commit();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
switch (position) {
    case 0 :
        fragmentManager.beginTransaction().replace( R.id.container,new FirstFragment() ).addToBackStack( "any" ).commit();
        break;
    case 1 :
        fragmentManager.beginTransaction().replace( R.id.container,new SecondFragment() ).addToBackStack( "any" ).commit();
        break;
    case 2 :
        fragmentManager.beginTransaction().replace( R.id.container,new ThirdFragment() ).addToBackStack( "any" ).commit();
        break;
}
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
