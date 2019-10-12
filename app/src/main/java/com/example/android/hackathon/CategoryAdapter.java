package com.example.android.hackathon;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {
    private Context mContext;
    public CategoryAdapter(FragmentManager tabs, Context context) {
        super(tabs);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new AddContractor();
        }else if (position == 1){
            return new AddProject();
        }
        else if (position == 2){
            return new ViewFeedback();
        }else {
            return new ViewPoll();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return "Add Contractor";
        }else if(position == 1){
            return "Add Project";
        }else if(position == 2){
            return "View Feedback";
        }else {
            return "View Poll";
        }
    }
}
