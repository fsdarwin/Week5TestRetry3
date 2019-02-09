package com.example.week5testretry3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import com.example.week5testretry3.adapters.RvAdapter;
import com.example.week5testretry3.events.SatEvent;
import com.example.week5testretry3.events.SchoolEvent;
import com.example.week5testretry3.events.UserEvent;
import com.example.week5testretry3.helpers.OkHttp3Helper;
import com.example.week5testretry3.pojos.Sat.Sat;
import com.example.week5testretry3.pojos.school.School;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import java.util.ArrayList;
import java.util.Arrays;
import static com.example.week5testretry3.constants.Constants.SAT_API;
import static com.example.week5testretry3.constants.Constants.SCHOOL_API;

public class MainActivity extends AppCompatActivity {
    //DECLARE variables
    public static final String TAG = "FRANK: ";
    School[] schools;
    ArrayList<School> schoolArrayList;
    Sat satsArr[];
    School selectedByUser;
    RecyclerView recyclerView;
    TextView tvVMath;
    TextView tvVReading;
    TextView tvVWriting;
    TextView tvVSchoolName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ASSOCIATE the TextViews
        tvVMath = findViewById(R.id.tvMath);
        tvVReading = findViewById(R.id.tvReading);
        tvVWriting = findViewById(R.id.tvWriting);
        tvVSchoolName = findViewById(R.id.tvSelectedSchoolName);

        //MAKE the API calls
        OkHttp3Helper.schoolAsyncOkHttpApiCall(SCHOOL_API, this);
        OkHttp3Helper.satAsyncOkHttpApiCall(SAT_API, this);

        //PRIME the recyclerView
        recyclerView = findViewById(R.id.rvAct1);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

    }
    //RETURNS the school list array
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(SchoolEvent event) {
        schools = event.getSchoolMessage();

        //MAKE an arrayList out of the returned values and push to the recyclerView
        schoolArrayList = new ArrayList<>(Arrays.asList(schools));
        RvAdapter rvAdapter = new RvAdapter(schoolArrayList);
        recyclerView.setAdapter(rvAdapter);
    }
    //RETURNS the sat score array
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(SatEvent event) {
        satsArr = event.getSatMessage();
        Log.d(TAG, "onEvent: SAT_DBN " + satsArr[0].getDbn());
    }
    //WHEN the user selects a list item
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(UserEvent event) {
        selectedByUser = event.getSelectedByUser();
        Log.d(TAG, "onEvent: UserEvent School DBN = " + selectedByUser.getDbn());

        //CYCLE through the sat score array until the correct school is found
        for (int i = 0; i < satsArr.length; i++){
            if (selectedByUser.getDbn().equals(satsArr[i].getDbn())){
                tvVMath.setText("Math = " + satsArr[i].getSatMathAvgScore());
                tvVReading.setText("Reading = " + satsArr[i].getSatCriticalReadingAvgScore());
                tvVWriting.setText("Writing = " + satsArr[i].getSatWritingAvgScore());
                tvVSchoolName.setText(selectedByUser.getSchoolName());
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
