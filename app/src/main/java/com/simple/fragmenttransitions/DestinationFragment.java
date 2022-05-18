package com.simple.fragmenttransitions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import android.view.ViewTreeObserver;



public class DestinationFragment extends Fragment {
    
    private static final String ARG_KIT = "allData";
    private AnimalList animList;
    private TextView word , meaning;
    
    public static DestinationFragment newInstance(AnimalList animL) {
        Bundle args = new Bundle();
        args.putParcelable(ARG_KIT, animL);
  
        DestinationFragment fragment = new DestinationFragment();
        fragment.setArguments(args);

        return fragment;
    }

    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.destination_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        word =  view.findViewById(R.id.destination_Word);
        meaning =  view.findViewById(R.id.destination_Meaning);
        
        animList = getArguments().getParcelable(ARG_KIT);
        word.setText(animList.getMWords());
        meaning.setText(animList.getMMeaning());
                       
                
        }
    
}
