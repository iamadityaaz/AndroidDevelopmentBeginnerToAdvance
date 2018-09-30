package project.ap.com.androiddevelopmentbeginnertoadvance.beginner;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import project.ap.com.androiddevelopmentbeginnertoadvance.R;
import project.ap.com.androiddevelopmentbeginnertoadvance.WebViewActivity;
import thereisnospon.codeview.CodeView;
import thereisnospon.codeview.CodeViewTheme;

public class AutoCompleteTextViewJava extends AppCompatActivity {

    private CodeView codeView;
    BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.xml:
                    // call pre-defined method to set code in xml code
                    xmlView();
                    return true;

                case R.id.java:

                    String java_code = "\n" +
                            "    @Override\n" +
                            "    protected void onCreate(Bundle savedInstanceState) {\n" +
                            "        super.onCreate(savedInstanceState);\n" +
                            "        setContentView(R.layout.activity_auto_complete_text_view_run);\n" +
                            "\n" +
                            "        String[] array={\"Motorola\",\"Apple\", \"Samsung\", \"Xiaomi\" ,\"Lenovo\"};\n" +
                            "\n" +
                            "        AutoCompleteTextView textView;\n" +
                            "\n" +
                            "        ArrayAdapter<String> adapter;\n" +
                            "\n" +
                            "        textView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);\n" +
                            "\n" +
                            "\n" +
                            "        adapter = new ArrayAdapter<String>(AutoCompleteTextViewRun.this,\n" +
                            "                android.R.layout.simple_list_item_1, array);\n" +
                            "\n" +
                            "        textView.setAdapter(adapter);\n" +
                            "\n" +
                            "    }";
                    //CODE is your code which  you want to show,type is String
                    codeView.showCode(java_code);
                    return true;



                case R.id.run:
                    //start run activity
                    startActivity(new Intent(getApplicationContext(), AutoCompleteTextViewRun.class));
                    return true;


                case R.id.theory:
                    startActivity(new Intent(getApplicationContext(), WebViewActivity.class));

                    return true;


            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view_java);


        //get the selected tutorial name from Main Activity
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String tutorial = prefs.getString("string_id", "null"); //no id: default value

        setTitle(tutorial);

        codeView = (CodeView) findViewById(R.id.codeview);
        codeView.setTheme(CodeViewTheme.DRACULA).fillColor();


        xmlView();

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        navigation.setVisibility(View.VISIBLE);
    }

    public void xmlView() {
        String xml_code = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<android.support.constraint.ConstraintLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                "    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" +
                "    xmlns:tools=\"http://schemas.android.com/tools\"\n" +
                "    android:layout_width=\"match_parent\"\n" +
                "    android:layout_height=\"match_parent\"\n" +
                "    tools:context=\".AutoCompleteTextViewRun\">\n" +
                "\n" +
                "    <AutoCompleteTextView\n" +
                "        android:id=\"@+id/autoCompleteTextView\"\n" +
                "        android:layout_width=\"0dp\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        android:layout_marginBottom=\"8dp\"\n" +
                "        android:layout_marginEnd=\"8dp\"\n" +
                "        android:layout_marginLeft=\"8dp\"\n" +
                "        android:layout_marginRight=\"8dp\"\n" +
                "        android:layout_marginStart=\"8dp\"\n" +
                "        android:layout_marginTop=\"8dp\"\n" +
                "        android:hint=\"Enter Here\"\n" +
                "        app:layout_constraintBottom_toBottomOf=\"parent\"\n" +
                "        app:layout_constraintEnd_toEndOf=\"parent\"\n" +
                "        app:layout_constraintStart_toStartOf=\"parent\"\n" +
                "        app:layout_constraintTop_toTopOf=\"parent\"\n" +
                "        app:layout_constraintVertical_bias=\"0.151\" />\n" +
                "\n" +
                "    <TextView\n" +
                "        android:id=\"@+id/textView\"\n" +
                "        android:layout_width=\"0dp\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        android:layout_marginEnd=\"8dp\"\n" +
                "        android:layout_marginLeft=\"8dp\"\n" +
                "        android:layout_marginRight=\"8dp\"\n" +
                "        android:layout_marginStart=\"8dp\"\n" +
                "        android:layout_marginTop=\"8dp\"\n" +
                "        android:text=\"Type Inputs:\\nMotorola, Apple, Samsung, Xiaomi, Lenovo\"\n" +
                "        app:layout_constraintEnd_toEndOf=\"parent\"\n" +
                "        app:layout_constraintStart_toStartOf=\"parent\"\n" +
                "        app:layout_constraintTop_toBottomOf=\"@+id/autoCompleteTextView\" />\n" +
                "\n" +
                "</android.support.constraint.ConstraintLayout>";
        //CODE is your code which  you want to show,type is String
        codeView.showCode(xml_code);

    }

}
