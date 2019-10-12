package com.example.android.hackathon;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter<Info> {
    private  int mColorResourceId;
    public Adapter(Activity context, ArrayList<Info> numbers, int colorResourceId) {
        super(context, 0, numbers);
        mColorResourceId = colorResourceId;
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.feeed_back_listview, parent, false);
        }

        Info currentWord = getItem(position);

        TextView TilteView = (TextView) listItemView.findViewById(R.id.title);
        TilteView.setText(currentWord.getmTitle());

        TextView detalisView= (TextView) listItemView.findViewById(R.id.description);
        detalisView.setText(currentWord.getmDescription());

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);
        return listItemView;
    }
}
