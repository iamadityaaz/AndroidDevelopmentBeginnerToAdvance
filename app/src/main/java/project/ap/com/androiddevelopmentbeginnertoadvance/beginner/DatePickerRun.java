package project.ap.com.androiddevelopmentbeginnertoadvance.beginner;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import project.ap.com.androiddevelopmentbeginnertoadvance.R;

public class DatePickerRun extends AppCompatActivity {

    DatePicker datepicker;
    Button displayDatebtn;
    TextView textview;
    StringBuilder builder;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_run);


        //get the selected tutorial name from Main Activity
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String tutorial = prefs.getString("string_id", "null"); //no id: default value

        setTitle(tutorial + " Output");


        textview = (TextView)findViewById(R.id.textDate);
        datepicker = (DatePicker)findViewById(R.id.datePicker);
        displayDatebtn = (Button)findViewById(R.id.setDateBtn);

        getDate();

        textview.setText("Current Date: "+ date);

        displayDatebtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                getDate();
                textview.setText("Change Date: " + date);
            }

        });
    }

    public void getDate(){
        builder = new StringBuilder();;
        builder.append(datepicker.getDayOfMonth() + "/");
        builder.append((datepicker.getMonth() + 1) +"/");//month starts with 0
        builder.append(datepicker.getYear());
        date = builder.toString();
    }
}
