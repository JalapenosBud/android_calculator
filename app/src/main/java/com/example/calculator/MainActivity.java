package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> calculate_list = new ArrayList<>();

    private boolean has_plus_been_clicked;
    private boolean has_divide_been_clicked;
    private boolean has_minus_been_clicked;
    private boolean has_multiply_been_clicked;
    private int counter = 0;

    private String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button_one = findViewById(R.id.button_one);
        Button button_two = findViewById(R.id.button_two);
        Button button_plus = findViewById(R.id.button_plus);
        Button button_equals = findViewById(R.id.button_equals);

        Button button_minus = findViewById(R.id.button_minus);
        Button button_multiply = findViewById(R.id.button_multiply);
        Button button_divide = findViewById(R.id.button_division);

        TextView result_text = findViewById(R.id.result_text_view);

        button_one.setOnClickListener((view -> {

            calculate_list.add(button_one.getText().toString());
            result_text.setText(calculate_list.get(calculate_list.size()-1));
            counter++;
        }));

        button_two.setOnClickListener((view -> {
            calculate_list.add(button_two.getText().toString());
            counter++;
            result_text.setText("counter: " + counter + " recent: " + calculate_list.get(calculate_list.size() - 1).toString());

        }));

        button_plus.setOnClickListener((view ->{
            has_plus_been_clicked = true;
            result_text.setText("counter: " + counter + " recent: " + calculate_list.get(0).toString());


        }));

        button_divide.setOnClickListener((view -> {
            has_divide_been_clicked = true;
        }));

        button_equals.setOnClickListener((view -> {

            int calculated = calculate(calculate_list.get(0),calculate_list.get(1));

            if(has_plus_been_clicked && counter == 2)
            {

                result_text.setText("" + calculated);
                result = "" + calculated;
            }
            if(has_divide_been_clicked && counter == 2)
            {
                result_text.setText("" + calculated);
                result = "" + calculated;
            }
            if(has_minus_been_clicked && counter == 2)
            {
                result_text.setText("" + calculated);
                result = "" + calculated;
            }
            if(has_multiply_been_clicked && counter == 2)
            {
                result_text.setText("" + calculated);
                result = "" + calculated;
            }
            counter = 0;
        }));

        /*if(has_plus_been_clicked && counter == 1)
        {
            result_text.setText(calculate_list.get(calculate_list.size() - 1));

        }*/
    }

    public int calculate(String one, String two){
        int tmpInt = Integer.parseInt(one);
        int tmpIntTwo = Integer.parseInt(two);

        return tmpInt + tmpIntTwo;
    }



}
