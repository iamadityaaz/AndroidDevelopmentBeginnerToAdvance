package project.ap.com.androiddevelopmentbeginnertoadvance.beginner;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import project.ap.com.androiddevelopmentbeginnertoadvance.R;
import project.ap.com.androiddevelopmentbeginnertoadvance.WebViewActivity;
import thereisnospon.codeview.CodeView;
import thereisnospon.codeview.CodeViewTheme;

public class CheckBoxJava extends AppCompatActivity {

    private CodeView codeView;

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

                    String java_code = "CheckBox pizza,maggie,burger;\n" +
                            "    Button buttonOrder;\n" +
                            "    @Override\n" +
                            "    protected void onCreate(Bundle savedInstanceState) {\n" +
                            "        super.onCreate(savedInstanceState);\n" +
                            "        setContentView(R.layout.activity_check_box_run);\n" +
                            "\n" +
                            "        pizza = (CheckBox)findViewById(R.id.checkBox);\n" +
                            "        maggie = (CheckBox)findViewById(R.id.checkBox2);\n" +
                            "        burger = (CheckBox)findViewById(R.id.checkBox3);\n" +
                            "        buttonOrder = (Button)findViewById(R.id.order);\n" +
                            "\n" +
                            "        buttonOrder.setOnClickListener(new View.OnClickListener(){\n" +
                            "\n" +
                            "            @Override\n" +
                            "            public void onClick(View view) {\n" +
                            "                int totalamount=0;\n" +
                            "                StringBuilder output = new StringBuilder();\n" +
                            "                output.append(\"Selected Items:\");\n" +
                            "                if(pizza.isChecked()){\n" +
                            "                    output.append(\"\\nPizza 100Rs\");\n" +
                            "                    totalamount += 100;\n" +
                            "                }\n" +
                            "                if(maggie.isChecked()){\n" +
                            "                    output.append(\"\\nMaggie 30Rs\");\n" +
                            "                    totalamount += 30;\n" +
                            "                }\n" +
                            "                if(burger.isChecked()){\n" +
                            "                    output.append(\"\\nBurger 120Rs\");\n" +
                            "                    totalamount += 120;\n" +
                            "                }\n" +
                            "\n" +
                            "                output.append(\"\\nTotal: \"+ totalamount +\"Rs\");\n" +
                            "\n" +
                            "                Toast.makeText(getApplicationContext(), output.toString(), Toast.LENGTH_LONG).show();\n" +
                            "            }\n" +
                            "\n" +
                            "        });\n" +
                            "\n" +
                            "    }";
                    //CODE is your code which  you want to show,type is String
                    codeView.showCode(java_code);
                    return true;



                case R.id.run:
                    //start run activity
                    startActivity(new Intent(getApplicationContext(), CheckBoxRun.class));
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

        // set code on start of the activity
        xmlView();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void xmlView() {
        String xml_code = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<android.support.constraint.ConstraintLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                "    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" +
                "    xmlns:tools=\"http://schemas.android.com/tools\"\n" +
                "    android:layout_width=\"fill_parent\"\n" +
                "    android:layout_height=\"fill_parent\">\n" +
                "\n" +
                "\n" +
                "    <CheckBox\n" +
                "        android:id=\"@+id/checkBox\"\n" +
                "        android:layout_width=\"wrap_content\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        android:layout_marginEnd=\"8dp\"\n" +
                "        android:layout_marginLeft=\"8dp\"\n" +
                "        android:layout_marginRight=\"8dp\"\n" +
                "        android:layout_marginStart=\"8dp\"\n" +
                "        android:layout_marginTop=\"68dp\"\n" +
                "        android:text=\"Pizza\"\n" +
                "        app:layout_constraintEnd_toEndOf=\"parent\"\n" +
                "        app:layout_constraintStart_toStartOf=\"parent\"\n" +
                "        app:layout_constraintTop_toTopOf=\"parent\" />\n" +
                "\n" +
                "    <CheckBox\n" +
                "        android:id=\"@+id/checkBox2\"\n" +
                "        android:layout_width=\"wrap_content\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        android:layout_marginEnd=\"8dp\"\n" +
                "        android:layout_marginLeft=\"8dp\"\n" +
                "        android:layout_marginRight=\"8dp\"\n" +
                "        android:layout_marginStart=\"8dp\"\n" +
                "        android:layout_marginTop=\"28dp\"\n" +
                "        android:text=\"Maggie\"\n" +
                "        app:layout_constraintEnd_toEndOf=\"parent\"\n" +
                "        app:layout_constraintStart_toStartOf=\"parent\"\n" +
                "        app:layout_constraintTop_toBottomOf=\"@+id/checkBox\" />\n" +
                "\n" +
                "    <CheckBox\n" +
                "        android:id=\"@+id/checkBox3\"\n" +
                "        android:layout_width=\"wrap_content\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        android:layout_marginEnd=\"8dp\"\n" +
                "        android:layout_marginLeft=\"8dp\"\n" +
                "        android:layout_marginRight=\"8dp\"\n" +
                "        android:layout_marginStart=\"8dp\"\n" +
                "        android:layout_marginTop=\"28dp\"\n" +
                "        android:text=\"Burger\"\n" +
                "        app:layout_constraintEnd_toEndOf=\"parent\"\n" +
                "        app:layout_constraintStart_toStartOf=\"parent\"\n" +
                "        app:layout_constraintTop_toBottomOf=\"@+id/checkBox2\" />\n" +
                "\n" +
                "    <Button\n" +
                "        android:id=\"@+id/order\"\n" +
                "        android:layout_width=\"wrap_content\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        android:layout_marginEnd=\"8dp\"\n" +
                "        android:layout_marginLeft=\"8dp\"\n" +
                "        android:layout_marginRight=\"8dp\"\n" +
                "        android:layout_marginStart=\"8dp\"\n" +
                "        android:layout_marginTop=\"36dp\"\n" +
                "        android:text=\"Order\"\n" +
                "        app:layout_constraintEnd_toEndOf=\"parent\"\n" +
                "        app:layout_constraintStart_toStartOf=\"parent\"\n" +
                "        app:layout_constraintTop_toBottomOf=\"@+id/checkBox3\" />\n" +
                "\n" +
                "\n" +
                "</android.support.constraint.ConstraintLayout>";
        //CODE is your code which  you want to show,type is String
        codeView.showCode(xml_code);

    }

}
