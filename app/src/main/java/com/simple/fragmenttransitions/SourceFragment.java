package com.simple.fragmenttransitions;

import android.os.Build;
import android.os.Bundle;
import android.transition.Fade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.List;
import android.widget.TextView;
import android.view.ViewTreeObserver;
import android.transition.Slide;


public class SourceFragment extends Fragment implements AnimalsCallback {

    private DatabaseTest db;
    private List <AnimalList> mAnimalList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    
  
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_grid, container, false);
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        
          
        db = new DatabaseTest(getContext());
        
        mAnimalList = db.getWordsAll();

        final RecyclerView recyclerView = view.findViewById(R.id.recyclerview);  
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new AnimalListAdapter(mAnimalList,this));
        

        postponeEnterTransition();

        recyclerView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                @Override
                public boolean onPreDraw(){
                    recyclerView.getViewTreeObserver().removeOnPreDrawListener(this);
                    startPostponedEnterTransition();
                    return true;
                }
            });
        
    }

    
    
    
    
    @Override
    public void onKittenClicked(int position, TextView sT) {
       
        AnimalList animL = mAnimalList.get(position);

        DestinationFragment animalDetails = DestinationFragment.newInstance(animL);
   
           animalDetails.setSharedElementEnterTransition(new SharedTransition());
           
           Slide s = new Slide();
           animalDetails.setEnterTransition(s);
           s.addTarget(R.id.destination_Meaning);             
           animalDetails.setExitTransition(s);
           
           animalDetails.setSharedElementReturnTransition(new SharedTransition());
        

        getActivity().getSupportFragmentManager()
            .beginTransaction()
            .setReorderingAllowed(true)
            .addSharedElement(sT, "sharedText")    
            .replace(R.id.container, animalDetails)
            .addToBackStack(null)
            .commit();
    }
}
