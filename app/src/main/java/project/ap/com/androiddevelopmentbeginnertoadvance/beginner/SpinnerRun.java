package project.ap.com.androiddevelopmentbeginnertoadvance.beginner;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import project.ap.com.androiddevelopmentbeginnertoadvance.R;

public class SpinnerRun extends AppCompatActivity {

    Spinner spinner;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_run);

        //get the selected tutorial name from Main Activity
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String tutorial = prefs.getString("string_id", "null"); //no id: default value

        setTitle(tutorial);

        spinner =  findViewById(R.id.spinner);
        button = findViewById(R.id.spinbtn);

        String brands[] = {"Motorola", "Apple", "Samsung", "Xiomi", "OnePlus"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplication(), R.layout.support_simple_spinner_dropdown_item, brands);
        spinner.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Selected : " + spinner.getSelectedItem(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
