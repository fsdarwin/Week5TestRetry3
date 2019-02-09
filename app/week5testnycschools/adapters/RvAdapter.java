package com.example.week5testnycschools.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.week5testnycschools.R;
import com.example.week5testnycschools.events.UserEvent;
import com.example.week5testnycschools.pojos.school.School;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {
    //DECLARATIONS
    ArrayList<com.example.week5testnycschools.pojos.school.School> schoolsArrayList;
    public static final String TAG = "FRANK: ";

    public RvAdapter(ArrayList<com.example.week5testnycschools.pojos.school.School> schoolsArrayList) {
        this.schoolsArrayList = schoolsArrayList;
    }

    @NonNull
    @Override
    public RvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvAdapter.ViewHolder viewHolder, int position) {

        School school = schoolsArrayList.get(position);
        if (school != null) {
            viewHolder.setItemSchool(school);

            String schoolName = school.getSchoolName();
            String schoolEmail = school.getSchoolEmail();

            viewHolder.tvSchoolName.setText(schoolName);
            viewHolder.tvSchoolEmail.setText(schoolEmail);
        }
    }

    @Override
    public int getItemCount() {
        return schoolsArrayList != null ? schoolsArrayList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvSchoolName;
        TextView tvSchoolEmail;
        School itemSchool;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvSchoolName = itemView.findViewById(R.id.tvRvSchoolName);
            tvSchoolEmail = itemView.findViewById(R.id.tvRvSchoolEmail);

            //ONCLICK listener for item selection
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EventBus.getDefault().post(new UserEvent(itemSchool));

                }
            });
        }

        public void setItemSchool(School itemSchool) {
            this.itemSchool = itemSchool;
        }
    }
}
