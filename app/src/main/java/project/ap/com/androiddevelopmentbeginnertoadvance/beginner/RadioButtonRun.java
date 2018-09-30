package project.ap.com.androiddevelopmentbeginnertoadvance.beginner;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioGroup;

import project.ap.com.androiddevelopmentbeginnertoadvance.R;

public class RadioButtonRun extends AppCompatActivity {

    ImageView imageView;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button_run);

        //get the selected tutorial name from Main Activity
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String tutorial = prefs.getString("string_id", "null"); //no id: default value

        setTitle(tutorial);

        imageView = (ImageView) findViewById(R.id.selected_image);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.books:
                        imageView.setImageResource(R.drawable.ic_library_books_black_24dp);
                        break;
                    case R.id.mobile:
                        imageView.setImageResource(R.drawable.ic_smartphone_black_24dp);
                        break;
                    case R.id.laptop:
                        imageView.setImageResource(R.drawable.ic_laptop_black_24dp);
                        break;
                }
            }
        });
    }
}
