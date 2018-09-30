package project.ap.com.androiddevelopmentbeginnertoadvance;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import project.ap.com.androiddevelopmentbeginnertoadvance.advance.AnimationRun;
import project.ap.com.androiddevelopmentbeginnertoadvance.beginner.AlertDialogueJava;
import project.ap.com.androiddevelopmentbeginnertoadvance.beginner.AutoCompleteTextViewJava;
import project.ap.com.androiddevelopmentbeginnertoadvance.beginner.ButtonJava;
import project.ap.com.androiddevelopmentbeginnertoadvance.beginner.CheckBoxJava;
import project.ap.com.androiddevelopmentbeginnertoadvance.beginner.DatePickerJava;
import project.ap.com.androiddevelopmentbeginnertoadvance.beginner.ImageViewJava;
import project.ap.com.androiddevelopmentbeginnertoadvance.beginner.ProgressBarJava;
import project.ap.com.androiddevelopmentbeginnertoadvance.beginner.RadioButtonJava;
import project.ap.com.androiddevelopmentbeginnertoadvance.beginner.RatingBarJava;
import project.ap.com.androiddevelopmentbeginnertoadvance.beginner.SeekBarJava;
import project.ap.com.androiddevelopmentbeginnertoadvance.beginner.SpinnerRun;
import project.ap.com.androiddevelopmentbeginnertoadvance.beginner.SwitchJava;
import project.ap.com.androiddevelopmentbeginnertoadvance.beginner.TimePickerJava;
import project.ap.com.androiddevelopmentbeginnertoadvance.beginner.ToastJava;
import project.ap.com.androiddevelopmentbeginnertoadvance.beginner.ToggleButtonJava;
import project.ap.com.androiddevelopmentbeginnertoadvance.beginner.editTextJava;
import project.ap.com.androiddevelopmentbeginnertoadvance.beginner.textViewJava;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_beginner:
                    // call pre-defined method to set code in beginner code
                    onstartStartActivity();
                    break;

//                    return true;
//                case R.id.navigation_advance:
//                    return true;
//                case R.id.navigation_tips:
//
//                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // Create an instance of the tab layout from the view.
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        // Set the text for each tab.
        tabLayout.addTab(tabLayout.newTab().setText("Codes"));
        tabLayout.addTab(tabLayout.newTab().setText("Videos"));
        // Set the tabs to fill the entire layout.
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        // Use PagerAdapter to manage page views in fragments.
        // Each page is represented by its own fragment.
        // This is another example of the adapter pattern.
        viewPager = (ViewPager) findViewById(R.id.pager);

        onstartStartActivity();
    }

    public  void onstartStartActivity(){


        // Use PagerAdapter to manage page views in fragments.
        // Each page is represented by its own fragment.
        // This is another example of the adapter pattern.

        PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        // Setting a listener for clicks.
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}
