package project.ap.com.androiddevelopmentbeginnertoadvance;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment1 extends Fragment {


    private ListView listView;
    private String[] items;

    /**
     * Called immediately after {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}
     * has returned, but before any saved state has been restored in to the view.
     * This gives subclasses a chance to initialize themselves once
     * they know their view hierarchy has been completely created.  The fragment's
     * view hierarchy is not however attached to its parent at this point.
     *
     * @param view               The View returned by {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        // set code on start of the activity
        setOnStart_Beginner();

    }


    public void setOnStart_Beginner(){
        items = new String[]{"TextView", "EditText", "Auto Complete TextView", "ImageView", "Button", "RadioButton and RadioGroup",
                "CheckBox", "Switch", "ToggleButton", "RatingBar", "SeekBar", "ProgressBar", "Spinner", "TimePicker", "DatePicker", "Toast Message", "Alert Dialog"};

        //  make array of the objectas according toto a layout design
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, android.R.id.text1, items);


        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //  Toast.makeText(getApplicationContext(), "" + position, Toast.LENGTH_SHORT).show();

                String  value = listView.getItemAtPosition(position).toString();

                //send selected tutorial name to documentation activity
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("string_id", value); //InputString: from the EditText
                editor.commit();

                switch (value) {
                    case "TextView":
                        Intent intent = new Intent(getContext(), textViewJava.class);
                        startActivity(intent);
                        break;
                    case "EditText":
                        startActivity(new Intent(getContext(), editTextJava.class));
                        break;
                    case "Auto Complete TextView":
                        startActivity(new Intent(getContext(), AutoCompleteTextViewJava.class));
                        break;
                    case "ImageView":
                        startActivity(new Intent(getContext(), ImageViewJava.class));
                        break;
                    case "Button":
                        startActivity(new Intent(getContext(), ButtonJava.class));
                        break;
                    case "RadioButton and RadioGroup":
                        startActivity(new Intent(getContext(), RadioButtonJava.class));
                        break;
                    case "CheckBox":
                        startActivity(new Intent(getContext(), CheckBoxJava.class));
                        break;
                    case "Switch":
                        startActivity(new Intent(getContext(), SwitchJava.class));
                        break;
                    case "ToggleButton":
                        startActivity(new Intent(getContext(), ToggleButtonJava.class));
                        break;
                    case "RatingBar":
                        startActivity(new Intent(getContext(), RatingBarJava.class));
                        break;
                    case "SeekBar":
                        startActivity(new Intent(getContext(), SeekBarJava.class));
                        break;
                    case "ProgressBar":
                        startActivity(new Intent(getContext(), ProgressBarJava.class));
                        break;
                    case "Spinner":
                        startActivity(new Intent(getContext(), SpinnerRun.class));
                        break;
                    case "TimePicker":
                        startActivity(new Intent(getContext(), TimePickerJava.class));
                        break;
                    case "DatePicker":
                        startActivity(new Intent(getContext(), DatePickerJava.class));
                        break;
                    case "Toast Message":
                        startActivity(new Intent(getContext(), ToastJava.class));
                        break;
                    case "Alert Dialog":
                        startActivity(new Intent(getContext(), AlertDialogueJava.class));
                        break;
                }
            }
        });
    }

    public void advance(){

        items = new String[] {"Animation", "StackView"};

        ArrayAdapter<String> adap = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, android.R.id.text1, items);

        listView.setAdapter(adap);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String value = listView.getItemAtPosition(position).toString();

                switch (value){

                    case "Animation":
                        startActivity(new Intent(getContext(), AnimationRun.class));
                        break;
                    case "StackView":
                        startActivity(new Intent(getContext(), AnimationRun.class));


                }

            }
        });

    }


    public TabFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.tab_fragment1, container, false);
        listView = view.findViewById(R.id.list_item);
        return view;
    }

}
