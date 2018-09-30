package project.ap.com.androiddevelopmentbeginnertoadvance.beginner;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import project.ap.com.androiddevelopmentbeginnertoadvance.R;

public class CheckBoxRun extends AppCompatActivity {

    CheckBox pizza,maggie,burger;
    Button buttonOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box_run);


        //get the selected tutorial name from Main Activity
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String tutorial = prefs.getString("string_id", "null"); //no id: default value

        setTitle(tutorial + " Output");

        pizza = (CheckBox)findViewById(R.id.checkBox);
        maggie = (CheckBox)findViewById(R.id.checkBox2);
        burger = (CheckBox)findViewById(R.id.checkBox3);
        buttonOrder = (Button)findViewById(R.id.order);

        buttonOrder.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                int totalamount=0;
                StringBuilder output = new StringBuilder();
                output.append("Selected Items:");
                if(pizza.isChecked()){
                    output.append("\nPizza 100Rs");
                    totalamount += 100;
                }
                if(maggie.isChecked()){
                    output.append("\nMaggie 30Rs");
                    totalamount += 30;
                }
                if(burger.isChecked()){
                    output.append("\nBurger 120Rs");
                    totalamount += 120;
                }

                output.append("\nTotal: "+ totalamount +"Rs");

                Toast.makeText(getApplicationContext(), output.toString(), Toast.LENGTH_LONG).show();
            }

        });

    }

}
