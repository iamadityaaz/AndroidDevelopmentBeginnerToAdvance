package project.ap.com.androiddevelopmentbeginnertoadvance.beginner;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import project.ap.com.androiddevelopmentbeginnertoadvance.R;

public class ToggleButtonRun extends AppCompatActivity {

    ToggleButton toggle;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button_run);


        //get the selected tutorial name from Main Activity
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String tutorial = prefs.getString("string_id", "null"); //no id: default value

        setTitle(tutorial);


        toggle = (ToggleButton) findViewById(R.id.toggleButton);
        textView = (TextView) findViewById(R.id.toogleText);

        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    textView.setText("Switch is On");
                } else {
                    textView.setText("");
                }
            }
        });
    }
}
