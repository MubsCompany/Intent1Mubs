package com.example.intent_1_mubs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {
    RecyclerView rvSecond;
    SecondAdapter secondAdapter;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate( R.layout.fragment_second, container, false );

        rvSecond = inflate.findViewById( R.id.rv_second );
        rvSecond.setLayoutManager( new GridLayoutManager( getActivity(), 2 ) );
        secondAdapter = new SecondAdapter( getContext() );
        rvSecond.setAdapter( secondAdapter );


        return inflate;
    }

}
