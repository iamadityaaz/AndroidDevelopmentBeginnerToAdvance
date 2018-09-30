package project.ap.com.androiddevelopmentbeginnertoadvance.beginner;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import project.ap.com.androiddevelopmentbeginnertoadvance.R;

public class SwitchRun extends AppCompatActivity {

    Switch aSwitch;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_run);


        //get the selected tutorial name from Main Activity
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String tutorial = prefs.getString("string_id", "null"); //no id: default value

        setTitle(tutorial + " Output");

        aSwitch = (Switch) findViewById(R.id.switch1);
        textView = (TextView) findViewById(R.id.switchText);

    }

    public void switchClicked(View view) {

        if (aSwitch.isChecked()){
            textView.setText("Swich is On");
        }
        else if (!aSwitch.isChecked()){
            textView.setText("Swich is Off");
        }

    }
}
