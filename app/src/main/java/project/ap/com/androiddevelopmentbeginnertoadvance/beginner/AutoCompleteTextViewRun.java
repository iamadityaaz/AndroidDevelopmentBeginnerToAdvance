package project.ap.com.androiddevelopmentbeginnertoadvance.beginner;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import project.ap.com.androiddevelopmentbeginnertoadvance.R;

public class AutoCompleteTextViewRun extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text_view_run);

        //get the selected tutorial name from Main Activity
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String tutorial = prefs.getString("string_id", "null"); //no id: default value

        setTitle(tutorial + " Output");

        String[] array={"Motorola","Apple", "Samsung", "Xiaomi" ,"Lenovo"};

        AutoCompleteTextView textView;

        ArrayAdapter<String> adapter;

        textView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);


        adapter = new ArrayAdapter<String>(AutoCompleteTextViewRun.this,
                android.R.layout.simple_list_item_1, array);

        textView.setAdapter(adapter);

    }
}
