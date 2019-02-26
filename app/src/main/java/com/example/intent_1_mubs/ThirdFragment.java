package com.example.intent_1_mubs;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFragment extends Fragment {
EditText edtEmail, edtWeb, edtPhone;
Button btnEmail, btnWeb, btnPhone;

    public ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View glue = inflater.inflate( R.layout.fragment_third, container, false );

        btnEmail = glue.findViewById( R.id.btn_email );
        btnPhone = glue.findViewById( R.id.btn_phone );
        btnWeb = glue.findViewById( R.id.btn_web );

        edtEmail = glue.findViewById( R.id.edt_email );
        edtPhone = glue.findViewById( R.id.edt_phone );
        edtWeb = glue.findViewById( R.id.edt_website );

        btnEmail.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent( Intent.ACTION_SEND);
               intent.setType( "text/plain" );
               intent.putExtra( Intent.EXTRA_SUBJECT,edtEmail.getText().toString() );
               intent.putExtra( Intent.EXTRA_TEXT,edtEmail.getText().toString() );
               startActivity( intent );
            }
        } );

btnPhone.setOnClickListener( new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity( new Intent( Intent.ACTION_DIAL,Uri.parse( "tel:" + edtPhone.getText() ) ) );
    }
} );

btnWeb.setOnClickListener( new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity( new Intent( Intent.ACTION_VIEW,Uri.parse( "http://www."+ edtWeb.getText().toString() ) ) );
    }
} );

        return glue;
    }

}
