package project.ap.com.androiddevelopmentbeginnertoadvance.beginner;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import project.ap.com.androiddevelopmentbeginnertoadvance.R;

public class editTextRun extends AppCompatActivity {


    EditText myeditText;
    TextView text;
    Button button;
    String enteredText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text_run);

        //get the selected tutorial name from Main Activity
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String tutorial = prefs.getString("string_id", "null"); //no id: default value

        setTitle(tutorial + " Output");

        myeditText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        text = findViewById(R.id.textViewXml);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enteredText = myeditText.getText().toString();
                text.setText(enteredText);

            }
        });


    }
}


