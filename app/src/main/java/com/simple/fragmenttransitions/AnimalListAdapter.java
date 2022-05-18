package com.simple.fragmenttransitions;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import androidx.recyclerview.widget.RecyclerView;
import androidx.core.view.ViewCompat;
import android.widget.TextView;


public class AnimalListAdapter extends RecyclerView.Adapter<AnimalListAdapter.KittenViewHolder> {

    private List<AnimalList> wordList;
    private AnimalsCallback mListener;



    public AnimalListAdapter(List<AnimalList> wordList, AnimalsCallback mListener) {
        this.wordList = wordList;
        this.mListener = mListener;
    } 


    @Override
    public KittenViewHolder onCreateViewHolder(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View v = inflater.inflate(R.layout.grid_item, container, false);

        return new KittenViewHolder(v);



    }

    @Override
    public void onBindViewHolder(final KittenViewHolder viewHolder, final int position) {

        AnimalList word = wordList.get(position);
        viewHolder.mText.setText(word.getMWords());   
        
        ViewCompat.setTransitionName(viewHolder.mText, String.valueOf(position) + "_text");
                
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onKittenClicked(position, viewHolder.mText);
                }
            });
    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }



    public class KittenViewHolder extends RecyclerView.ViewHolder {

        TextView mText;

        public KittenViewHolder(View itemView) {
            super(itemView);

            mText =  itemView.findViewById(R.id.textWord);

        }

    }

}
