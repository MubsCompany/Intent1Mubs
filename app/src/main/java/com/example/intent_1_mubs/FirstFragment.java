package com.example.intent_1_mubs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {
    RecyclerView rvFirst;
    FirstAdapter firstAdapter;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate( R.layout.fragment_first, container, false );

        rvFirst = v.findViewById( R.id.rv_first );
        firstAdapter = new FirstAdapter( getContext() );
        rvFirst.setLayoutManager( new LinearLayoutManager( getActivity(), LinearLayoutManager.VERTICAL, false ) );
        rvFirst.setAdapter( firstAdapter );
        return v;
    }

}
