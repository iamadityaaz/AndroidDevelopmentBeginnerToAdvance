package project.ap.com.androiddevelopmentbeginnertoadvance.beginner;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import project.ap.com.androiddevelopmentbeginnertoadvance.R;

public class TimePickerRun extends AppCompatActivity {

    TextView textview1;
    TimePicker timepicker;
    Button changetimebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker_run);

        //get the selected tutorial name from Main Activity
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String tutorial = prefs.getString("string_id", "null"); //no id: default value

        setTitle(tutorial + " Output");

        textview1 = (TextView) findViewById(R.id.timeText);
        timepicker = (TimePicker) findViewById(R.id.timePicker);
        changetimebtn = (Button) findViewById(R.id.timeButton);

        timepicker.setIs24HourView(true);
        textview1.setText(getCurrentTime());

        changetimebtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                textview1.setText(getCurrentTime());
            }
        });
    }

    public String getCurrentTime(){
        String currentTime = "Current Time: "+ timepicker.getCurrentHour() + ":" + timepicker.getCurrentMinute();
        return currentTime;
    }
}
